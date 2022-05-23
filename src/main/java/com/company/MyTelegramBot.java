package com.company;

import com.company.container.ComponentContainer;
import com.company.controller.LanguageController;
import com.company.controller.MainController;
import com.company.controllerEn.MainControllerEn;
import com.company.controllerRu.MainControllerRu;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;

public class MyTelegramBot extends TelegramLongPollingBot {
    private MainController mainController = new MainController();
    private MainControllerRu mainControllerRu = new MainControllerRu();
    private MainControllerEn mainControllerEn = new MainControllerEn();
    private LanguageController languageController = new LanguageController();

    @Override
    public String getBotUsername() {
        return "max_way_UTD_bot";
    }

    @Override
    public String getBotToken() {
        return "5240333411:AAEwPb0sPAExIoRgtBcWvS7ghRKfp78O4N0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                User user = message.getFrom();
                if (message.hasText()) {
                    log(user, message.getText());
                    if (ComponentContainer.languageStatusMap.containsKey(user.getId())) {
                        switch (ComponentContainer.languageStatusMap.get(user.getId())) {
                            case UZ -> {
                                mainController.handleText(user, message);
                            }
                            case RU -> {
                                mainControllerRu.handleTextRu(user, message);
                            }
                            case EN -> {
                                mainControllerEn.handleTextEn(user, message);
                            }
                        }
                    } else {
                        languageController.handleText(user, message);
                    }
                } else if (message.hasPhoto()) {
                    if (ComponentContainer.languageStatusMap.containsKey(user.getId())) {
                        switch (ComponentContainer.languageStatusMap.get(user.getId())) {
                            case UZ -> {
                                mainController.handlePhoto(user, message);
                            }
                            case RU -> {
                                mainControllerRu.handlePhotoRu(user, message);
                            }
                            case EN -> {
                                mainControllerEn.handlePhotoEn(user,message);
                            }
                        }
                    }
                } else if (message.hasVideo()) {
                    if (ComponentContainer.languageStatusMap.containsKey(user.getId())) {
                        switch (ComponentContainer.languageStatusMap.get(user.getId())) {
                            case UZ -> {
                                mainController.handleVideo(user, message);
                            }
                            case RU -> {
                                mainControllerRu.handleVideoRu(user, message);
                            }
                            case EN -> {
                                mainControllerEn.handleVideoEn(user, message);
                            }
                        }
                    }
                } else if (message.hasContact()) {
                    if (ComponentContainer.languageStatusMap.containsKey(user.getId())) {
                        switch (ComponentContainer.languageStatusMap.get(user.getId())) {
                            case UZ -> {
                                mainController.handleContact(message);
                            }
                            case RU -> {
                                mainControllerRu.handleContactRu(message);
                            }
                            case EN -> {
                                mainControllerEn.handleContact(message);
                            }
                        }
                    }
                } else if (message.hasLocation()) {
                    if (ComponentContainer.languageStatusMap.containsKey(user.getId())) {
                        switch (ComponentContainer.languageStatusMap.get(user.getId())) {
                            case UZ -> {
                                mainController.handleLocation(user, message);
                            }
                            case RU -> {
                                mainControllerRu.handleLocationRu(user, message);
                            }
                            case EN -> {
                                mainControllerEn.handleLocationEn(user, message);
                            }
                        }
                    }
                }
            } else if (update.hasCallbackQuery()){
                Message message = update.getCallbackQuery().getMessage();
                User user = update.getCallbackQuery().getFrom();
                String text = update.getCallbackQuery().getData();
                log(user, text);
                languageController.handleCallBack(user, message, text);
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }


    public void send(Object obj) {
        try {
            if (obj instanceof SendMessage) {
                execute((SendMessage) obj);
            } else if (obj instanceof SendPhoto) {
                execute((SendPhoto) obj);
            } else if (obj instanceof SendVideo) {
                execute((SendVideo) obj);
            } else if (obj instanceof SendLocation) {
                execute((SendLocation) obj);
            } else if (obj instanceof SendContact) {
                execute((SendContact) obj);
            } else if (obj instanceof EditMessageText) {
                execute((EditMessageText) obj);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();

        }
    }

    public void log(User user, String text) {
        String str = String.format(LocalDateTime.now() + ",  userId: %d, firstName: %s, lastName: %s, text: %s",
                user.getId(), user.getFirstName(), user.getLastName(), text);
        System.out.println(str);
    }
}