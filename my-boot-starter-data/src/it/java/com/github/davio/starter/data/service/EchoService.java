package com.github.davio.starter.data.service;

import com.github.davio.starter.data.model.EchoMapper;
import com.github.davio.starter.data.model.EchoMessage;
import com.github.davio.starter.data.repository.EchoRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class EchoService {

    private final EchoRepository echoRepository;
    private final EchoMapper echoMapper;

    public EchoMessage processEcho(EchoMessage echoMessage) {
        return echoMapper.toMessage(echoRepository.save(echoMapper.toEntity(echoMessage)));
    }
}
