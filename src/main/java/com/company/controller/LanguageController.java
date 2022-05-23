package com.company.controller;

import com.company.container.ComponentContainer;
import com.company.enums.LanguageStatus;
import com.company.util.KeyboardButtonUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

public class LanguageController {

    public void handleText(User user, Message message) {
        String text = message.getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        switch (text) {
            case "/start" -> {
                String builder = "Assalomu Aleykum United Developers Team buyurtma botiga hush kelibsiz \n\nAvval Tilni Tanlab Olaylik \uD83D\uDE0A\uD83D\uDE0A";
                sendMessage.setText(builder);
                sendMessage.setReplyMarkup(KeyboardButtonUtil.menuLenguage());
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDDFA\uD83C\uDDFF O'zbekcha" -> {
                ComponentContainer.languageStatusMap.put(user.getId(), LanguageStatus.UZ);
                ComponentContainer.mainController.handleText(user,message);
            }
            case "\uD83C\uDDF7\uD83C\uDDFA Русский" -> {
                ComponentContainer.languageStatusMap.put(user.getId(), LanguageStatus.RU);
                ComponentContainer.mainControllerRu.handleTextRu(user, message);
            }
            case "\uD83C\uDDF1\uD83C\uDDF7 English" ->{
                ComponentContainer.languageStatusMap.put(user.getId(), LanguageStatus.EN);
                ComponentContainer.mainControllerEn.handleTextEn(user, message);
            }
            default ->{
                sendMessage.setText("Botni qaytadan ishga tushuring  /start");
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }

        }
    }

    public void handleCallBack(User user, Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(user.getId()));
        if(ComponentContainer.languageStatusMap.containsKey(user.getId())){
            switch (ComponentContainer.languageStatusMap.get(user.getId())){
                case UZ ->  {
                    ComponentContainer.mainController.handleCallBack(user, message, text);

                }
                case RU -> {
                    ComponentContainer.mainControllerRu.handleCallBack(user, message, text);
                }
                case EN -> {
                    ComponentContainer.mainControllerEn.handleCallBack(user, message, text);
                }
            }
        }

    }
}
