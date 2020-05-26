package com.github.davio.starter.interfaces.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
public class FeignOAuthConfiguration {

    @ConditionalOnBean(ClientCredentialsResourceDetails.class)
    @Bean
    @Qualifier("clientCredentialsOAuth2FeignRequestInterceptor")
    public OAuth2FeignRequestInterceptor oauth2schemeRequestInterceptor(
            @Autowired ClientCredentialsResourceDetails clientCredentialsResourceDetails) {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails);
    }
}


