package com.ftd.info_bot_game.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageBundle {

    private final MessageSource messageSource;

    public MessageBundle(@Qualifier("messageSource") MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    public String loadMessage(String key, Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }

    public String loadMessage(String key) {
        return messageSource.getMessage(key, null, new Locale("ru"));
    }
}