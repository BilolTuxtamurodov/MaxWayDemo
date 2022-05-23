package com.company.controllerRu;

import com.company.container.ComponentContainer;
import com.company.enums.UserStatus;
import com.company.util.KeyboardButtonUtilRu;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

public class OrderControllerRu {
    public void ordersRu(User user , Message message){
        String text = message.getText();
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(message.getChatId()));
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        switch (text) {
            case "\uD83E\uDD6A \uD83C\uDF5F \uD83E\uDD64 Kombo" -> {
                sendMessage.setText("Категория " + "\uD83E\uDD6A \uD83C\uDF5F \uD83E\uDD64 Kombo");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.komboMenuRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDD6A Klab Sendvich" -> {
                sendMessage.setText("Категория " + "\uD83E\uDD6A Klab Sendvich");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.klabMenuRu(user));
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF54 Burger" -> {
                sendMessage.setText("Категория " + "\uD83C\uDF54 Burger");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.burgerMenuRu(user));
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF71 Donar Blyudo" -> {
                sendMessage.setText("Категория " + "\uD83C\uDF71 Donar");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.donarMenuRu(user));
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF2F Lavash" -> {
                sendMessage.setText("Категория " + "\uD83C\uDF2F Lavash");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.lavashMenuRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDDC6 Shourma" -> {
                sendMessage.setText("Категория " + "\uD83E\uDDC6 Shourma");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.shourmaMenuRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF5F Sneklar" -> {
                sendMessage.setText("Категория " + "\uD83C\uDF5F Sneklar");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.snekMenuRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF2D Xot Dog" -> {
                sendMessage.setText("Категория " + "\uD83C\uDF2D Xot Dog");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.xotDogMenuRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDDC6 Garnirlar" -> {
                sendMessage.setText("Категория " + "\uD83E\uDDC6 Garnirlar");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.garnirMenuRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDD64\uD83E\uDD64 Napitki" -> {
                sendMessage.setText("Категория " + "\uD83E\uDD64\uD83E\uDD64 Napitki");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.napitkiMenuRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF70 Deserti" -> {
                sendMessage.setText("Категория " + "\uD83C\uDF70 Deserti");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.desertMenuRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF5F Sneki" -> {
                sendMessage.setText("Категория " + "\uD83C\uDF5F Sneki");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.snekiiRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDED5 Souslar" -> {
                sendMessage.setText("Категория " + "\uD83E\uDED5 Souslar");
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.sousiMenuRu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
        }
    }

    public void choiseNumRu(User user, Message message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText("Введите номер: ");
        sendMessage.setReplyMarkup(KeyboardButtonUtilRu.choiseNumMenuRu());

        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        ComponentContainer.userStatusMap.remove(user.getId());
    }
}
