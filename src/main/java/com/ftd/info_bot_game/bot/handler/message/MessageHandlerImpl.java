package com.ftd.info_bot_game.bot.handler.message;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MessageHandlerImpl implements MessageHandler {
    @Override
    public BotApiMethod<?> processMessage(Message message) throws TelegramApiException {
        return null;
    }
}
