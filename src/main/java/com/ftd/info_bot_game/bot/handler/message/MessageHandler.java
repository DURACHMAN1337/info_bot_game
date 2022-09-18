package com.ftd.info_bot_game.bot.handler.message;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface MessageHandler {
    BotApiMethod<?> processMessage(Message message) throws TelegramApiException;
}