package com.company.controllerEn;

import com.company.container.ComponentContainer;
import com.company.enums.UserStatus;
import com.company.util.KeyboardButtonUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

public class OrderControllerEn {
    public void ordersEn(User user , Message message){
        String text = message.getText();
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(message.getChatId()));
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        switch (text) {
            case "\uD83E\uDD6A \uD83C\uDF5F \uD83E\uDD64 Kombo" -> {
                sendMessage.setText("Bo'lim " + "\uD83E\uDD6A \uD83C\uDF5F \uD83E\uDD64 Kombo");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.komboMenu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDD6A Klab Sendvich" -> {
                sendMessage.setText("Bo'lim " + "\uD83E\uDD6A Klab Sendvich");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.klabMenu(user));
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF54 Burger" -> {
                sendMessage.setText("Bo'lim " + "\uD83C\uDF54 Burger");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.burgerMenu(user));
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF71 Donar Blyudo" -> {
                sendMessage.setText("Bo'lim " + "\uD83C\uDF71 Donar");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.donarMenu(user));
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF2F Lavash" -> {
                sendMessage.setText("Bo'lim " + "\uD83C\uDF2F Lavash");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.lavashMenu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDDC6 Shourma" -> {
                sendMessage.setText("Bo'lim " + "\uD83E\uDDC6 Shourma");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.shourmaMenu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF5F Sneklar" -> {
                sendMessage.setText("Bo'lim " + "\uD83C\uDF5F Sneklar");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.snekMenu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF2D Xot Dog" -> {
                sendMessage.setText("Bo'lim " + "\uD83C\uDF2D Xot Dog");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.xotDogMenu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDDC6 Garnirlar" -> {
                sendMessage.setText("Bo'lim " + "\uD83E\uDDC6 Garnirlar");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.garnirMenu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDD64\uD83E\uDD64 Napitki" -> {
                sendMessage.setText("Bo'lim " + "\uD83E\uDD64\uD83E\uDD64 Napitki");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.napitkiMenu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF70 Deserti" -> {
                sendMessage.setText("Bo'lim " + "\uD83C\uDF70 Deserti");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.desertMenu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83C\uDF5F Sneki" -> {
                sendMessage.setText("Bo'lim " + "\uD83C\uDF5F Sneki");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.snekii());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
            case "\uD83E\uDED5 Souslar" -> {
                sendMessage.setText("Bo'lim " + "\uD83E\uDED5 Souslar");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.sousiMenu());
                ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_MENU);
                ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            }
        }
    }

    public void choiseNumEn(User user, Message message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText("Sonini kiriting: ");
        sendMessage.setReplyMarkup(KeyboardButtonUtil.choiseNumMenu());

        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        ComponentContainer.userStatusMap.remove(user.getId());
    }
}
