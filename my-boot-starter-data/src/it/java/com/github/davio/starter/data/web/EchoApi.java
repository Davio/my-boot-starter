package com.github.davio.starter.data.web;

import com.github.davio.starter.data.model.EchoMessage;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface EchoApi {

    @RequestMapping(value = "/echo",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.POST)
    ResponseEntity<EchoMessage> echo(@RequestBody EchoMessage message);
}
