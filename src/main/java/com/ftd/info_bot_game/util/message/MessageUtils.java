package com.ftd.info_bot_game.util.message;

import org.springframework.util.MimeTypeUtils;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;

import javax.annotation.Nullable;

public class MessageUtils {

    @Nullable
    public static Long getTelegramUserIdFromComment(Message message) {
        Message replyToMessage = message.getReplyToMessage();
        if (replyToMessage == null) {
            replyToMessage = message; // when we create feedback post firstly
        }

        final String[] split = replyToMessage.getText().split("\n");
        if (split.length == 3) {
            return Long.valueOf(split[0]);
        }

        return null;
    }

    public static boolean isImage(Document document) {
        return MimeTypeUtils.parseMimeType(document.getMimeType()).getType().equals("image");
    }

}
