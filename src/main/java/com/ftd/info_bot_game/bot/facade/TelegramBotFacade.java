package com.ftd.info_bot_game.bot.facade;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface TelegramBotFacade {
    PartialBotApiMethod<?> processUpdate(Update update) throws TelegramApiException;
}
