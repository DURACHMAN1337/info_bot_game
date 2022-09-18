package com.ftd.info_bot_game.bot.handler.callback;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class CallbackQueryHandlerImpl implements CallbackQueryHandler {
    @Override
    public PartialBotApiMethod<?> processCallbackQuery(CallbackQuery callbackQuery) throws TelegramApiException {
        return null;
    }
}
