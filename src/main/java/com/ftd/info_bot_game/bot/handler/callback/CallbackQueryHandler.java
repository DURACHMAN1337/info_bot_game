package com.ftd.info_bot_game.bot.handler.callback;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface CallbackQueryHandler {
    PartialBotApiMethod<?> processCallbackQuery(CallbackQuery callbackQuery) throws TelegramApiException;
}
