package com.github.davio.starter.sandbox;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class SandboxController {

    private final SandboxService sandboxService;

    @GetMapping(value = "/answer", produces = MediaType.TEXT_PLAIN_VALUE)
    public String get() {
        return sandboxService.getAnswers();
    }
}
