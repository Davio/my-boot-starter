package com.github.davio.starter.interfaces.messaging;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.impl.MicrometerMetricsCollector;

import org.aopalliance.intercept.MethodInterceptor;
import org.slf4j.MDC;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.Metrics;

@Configuration
@EnableRabbit
public class RabbitAutoConfiguration {

    public static final int MSG_TTL = 60000 * 70;
    public static final int QUEUE_TTL = 60000 * 2;

    static ConnectionFactory getConnectionFactory(String addresses, String username, String password, String virtualhost) {
        com.rabbitmq.client.ConnectionFactory rabbitConnectionFactory = new com.rabbitmq.client.ConnectionFactory();
        rabbitConnectionFactory.setAutomaticRecoveryEnabled(false);
        String[] hostAndPort = addresses.split(":");
        rabbitConnectionFactory.setHost(hostAndPort[0]);
        rabbitConnectionFactory.setPort(hostAndPort.length > 1 ? Integer.parseInt(hostAndPort[1]) : 5672);
        rabbitConnectionFactory.setUsername(username);
        rabbitConnectionFactory.setPassword(password);
        rabbitConnectionFactory.setVirtualHost(virtualhost);
        rabbitConnectionFactory.setMetricsCollector(new MicrometerMetricsCollector(Metrics.globalRegistry));
        return new CachingConnectionFactory(rabbitConnectionFactory);
    }

    public static Queue createQueue(AmqpAdmin amqpAdmin,
                                    String queueName,
                                    Integer messageTTL,
                                    Integer queueTTL,
                                    boolean durable) {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-message-ttl", messageTTL);

        if (!durable) {
            arguments.put("x-expires", queueTTL);
        }

        Queue queue = new Queue(queueName, durable, false, false, arguments);
        queue.setAdminsThatShouldDeclare(amqpAdmin);
        return queue;
    }

    public static Queue createQueue(AmqpAdmin amqpAdmin,
                                    String queueName,
                                    boolean durable) {
        return createQueue(amqpAdmin, queueName, MSG_TTL, QUEUE_TTL, durable);
    }

    @ConditionalOnMissingBean
    @Bean
    public MessageRecoverer messageRecoverer() {
        return new RejectAndDontRequeueRecoverer();
    }

    @ConditionalOnMissingBean(name = "rabbitMqRetryAdvice")
    @Bean
    public MethodInterceptor rabbitMqRetryAdvice(MessageRecoverer messageRecoverer) {
        return RetryInterceptorBuilder
                .stateless()
                .maxAttempts(3)
                .recoverer(messageRecoverer)
                .backOffOptions(1000, 2, 5000)
                .build();
    }

    @ConditionalOnMissingBean(name = "rabbitMqMdcAdvice")
    @Bean
    public MethodInterceptor rabbitMqMdcAdvice() {
        return invocation -> {
            try {
                return invocation.proceed();
            } finally {
                MDC.clear();
            }
        };
    }

    public static String getInstanceQueueName(String prefix) {
        String hostname;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "localhost";
        }

        return prefix + "." + hostname;
    }
}
