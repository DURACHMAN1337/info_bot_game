package com.ftd.info_bot_game.util.request;

import com.ftd.info_bot_game.bot.longpolling.LongPollingBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.Nullable;
import java.io.File;
import java.util.List;

import static com.ftd.info_bot_game.util.message.MessageUtils.isImage;

@Component
public class RequestHelper {

    private static final String GET_UPDATES_URL = "https://api.telegram.org/bot%s/getUpdates?chat_id=%s";
    private final ApplicationContext applicationContext;

    @Autowired
    public RequestHelper(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Nullable
    public File getPhotoFrom(Message message) {
        final LongPollingBot bot = applicationContext.getBean(LongPollingBot.class);
        final String fileId;
        if (message.hasPhoto()) {
            List<PhotoSize> photoSizes = message.getPhoto();
            PhotoSize photoSize = photoSizes.get(photoSizes.size() - 1);
            fileId = photoSize.getFileId();
        } else if (message.hasDocument() && isImage(message.getDocument())) {
            fileId = message.getDocument().getFileId();
        } else {
            return null;
        }

        try {
            final String filePath = bot.execute(new GetFile(fileId)).getFilePath();
            return filePath != null ? bot.downloadFile(filePath) : null;
        } catch (TelegramApiException e) {
            return null;
        }
    }
}
