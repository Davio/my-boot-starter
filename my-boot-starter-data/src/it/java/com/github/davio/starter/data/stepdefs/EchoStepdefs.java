package com.github.davio.starter.data.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.davio.starter.data.model.EchoMessage;
import com.github.davio.starter.data.web.EchoApiClient;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class EchoStepdefs {

    private final EchoApiClient echoClient;

    private EchoMessage echoMessage;

    @Given("I send the message {string}")
    public void sendMessage(String message) {
        EchoMessage echoMessage = new EchoMessage(message);
        this.echoMessage = echoClient.echo(echoMessage).getBody();
        log.debug("Sent echo message {}", message);
    }

    @Then("the returned message equals {string}")
    public void checkReturnedMessage(String expectedMessage) {
        log.debug("Received echo message {}", echoMessage.getMessage());
        assertThat(echoMessage.getMessage()).isEqualTo(expectedMessage);
    }
}
