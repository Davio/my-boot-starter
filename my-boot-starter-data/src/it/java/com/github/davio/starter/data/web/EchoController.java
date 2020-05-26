package com.github.davio.starter.data.web;

import static org.springframework.http.ResponseEntity.ok;

import com.github.davio.starter.data.model.EchoMessage;
import com.github.davio.starter.data.service.EchoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class EchoController implements EchoApi {

    private final EchoService echoService;

    @Override
    public ResponseEntity<EchoMessage> echo(EchoMessage echoMessage) {
        log.info("Received Echo request for message {}", echoMessage.getMessage());
        return ok(echoService.processEcho(echoMessage));
    }
}
