package com.github.davio.starter.interfaces.rest;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Zorgt ervoor dat de String geldigheid parameter van de binnenkomende request juist geconverteerd
 * wordt naar een LocalDateTime object.
 */
@ControllerAdvice
public class LocalDateTimeControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                this.setValue(LocalDateTime.parse(text));
            }
        });
    }
}
