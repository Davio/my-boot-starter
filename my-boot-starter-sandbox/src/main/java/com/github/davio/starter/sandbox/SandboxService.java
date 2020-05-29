package com.github.davio.starter.sandbox;

import com.github.davio.starter.MyService;
import com.github.davio.starter.OtherService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SandboxService {

    // These fields are autowired into the constructor by Spring magic! (and some Lombok)
    private final MyService myService;
    private final OtherService otherService;

    public String getAnswers() {
        return myService.getRandomNumber()
               + " "
               + otherService.getTheAnswerToTheUltimateQuestionOfLifeTheUniverseAndEverything();
    }
}
