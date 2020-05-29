package com.github.davio.starter;

public interface OtherService {

    default String getTheAnswerToTheUltimateQuestionOfLifeTheUniverseAndEverything() {
        return "42"; // Calculated by 'Deep Thought' over a period of 7.5 million years
    }
}
