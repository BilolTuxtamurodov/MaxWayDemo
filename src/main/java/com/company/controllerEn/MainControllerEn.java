package com.company.controllerEn;

import com.company.container.ComponentContainer;
import com.company.controller.LanguageController;
import com.company.entty.FastFood;
import com.company.enums.UserStatus;
import com.company.util.KeyboardButtonUtil;
import com.company.util.KeyboardButtonUtilEn;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class MainControllerEn {
    private List<FastFood> fastFoodList = new LinkedList<>();
    private LanguageController languageController = new LanguageController();
    private static double amount = 0;

    public void handleTextEn(User user, Message message) {
        String text = message.getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if (text.equals("\uD83D\uDD04 Change the language")) {
            sendMessage.setText("Select a language");
            sendMessage.setReplyMarkup(KeyboardButtonUtilEn.menuLenguageEn());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.languageStatusMap.remove(user.getId());
            fastFoodList.clear();
            amount = 0;
        } else if (text.equals("/start")) {
            ComponentContainer.languageStatusMap.remove(user.getId());
            languageController.handleText(user, message);
        } else if (text.equals("\uD83C\uDDF1\uD83C\uDDF7 English")) {
            String builder = "Welcome ! <b>" + user.getFirstName() + "</b>\n";
            sendMessage.setText(builder);
            sendMessage.setParseMode("HTML");
            sendMessage.setReplyMarkup(KeyboardButtonUtilEn.asosiyMenuEn());
            messageToAdminEn(user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("♻️ Cleaning")) {
            fastFoodList.clear();
            amount = 0;
            sendMessage.setText("Cleared.");
            sendMessage.setReplyMarkup(KeyboardButtonUtilEn.MaxWayMenuEn());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDE98 Ordering")) {
            sendMessage.setText("Please Send Your Number or (998xxxxxxx) Send in View");
            sendMessage.setReplyMarkup(KeyboardButtonUtilEn.contactEn());
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.PHONE_NUMBER);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("⬅ Back")) {
            sendMessage.setText("Asosiy menu");
            sendMessage.setReplyMarkup(KeyboardButtonUtilEn.asosiyMenuEn());
            ComponentContainer.userStatusMap.remove(user.getId());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("◀️ Back")) {
            sendMessage.setText("Continue ordering");
            sendMessage.setReplyMarkup(KeyboardButtonUtilEn.MaxWayMenuEn());
            ComponentContainer.userStatusMap.remove(user.getId());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (ComponentContainer.userStatusMap.containsKey(user.getId())) {
            switch (ComponentContainer.userStatusMap.get(user.getId())) {
                case FOODS_MENU -> {
                    ComponentContainer.orderControllerEn.choiseNumEn(user, message);
                    ComponentContainer.userStatusMap.remove(user.getId());
                }
                case ORDERS_MENU -> {
                    ComponentContainer.ORDER_MENU_CONTROLLER_EN.equalEn(user, message);
                    sendMessage.setText("Select the quantity: ");
                    sendMessage.setReplyMarkup(KeyboardButtonUtilEn.choiseNumMenuEn());
                    ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                    ComponentContainer.userStatusMap.remove(user.getId());
                    ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
                }
                case ASOSIY_MENU -> {
                    sendMessage.setText("Continue ordering");
                    sendMessage.setReplyMarkup(KeyboardButtonUtilEn.MaxWayMenuEn());
                    ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                    ComponentContainer.userStatusMap.remove(user.getId());
                }
                case ORDERS_NUM -> {
                    FastFood fastFood = ComponentContainer.currentFastFood;
                    if (fastFood.getUser().getId().equals(user.getId())) {
                        int count = Integer.parseInt(text);
                        amount += (count * fastFood.getAmount());
                        fastFood.setCount(count);
                        fastFoodList.add(fastFood);
                        sendMessage.setText("Continue ordering");
                        sendMessage.setReplyMarkup(KeyboardButtonUtilEn.MaxWayMenuEn());
                        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                        ComponentContainer.userStatusMap.remove(user.getId());
                    }
                }
                case PHONE_NUMBER -> {
                    Contact contact = checkPhoneEn(text, user);
                    if (contact != null) {
                        System.out.println(contact.getFirstName() + " " + contact.getPhoneNumber());
                        SendMessage toUser = new SendMessage();
                        toUser.setChatId(String.valueOf(message.getChatId()));
                        toUser.setReplyMarkup(KeyboardButtonUtilEn.locationEn());
                        toUser.setText("Accepted\n\nSend your location ");
                        ComponentContainer.MY_TELEGRAM_BOT.send(toUser);
                        ComponentContainer.contactMap.put(contact.getUserId(), contact);
                        ComponentContainer.userStatusMap.remove(user.getId());
                    } else {
                        sendMessage.setText("Number Error Added \nTry again");
                        sendMessage.setReplyMarkup(KeyboardButtonUtilEn.contactEn());
                        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                    }
                }
            }
        } else if (text.equals("\uD83D\uDE95 Ordering")) {
            sendMessage.setParseMode("HTML");
            String builder = "<a href=\"https://telegra.ph/Tashkent-MaxWay-menu-10-03\">MaxWay Menu</a>";
            sendMessage.setText("Select a category\n" + builder);
            sendMessage.setReplyMarkup(KeyboardButtonUtilEn.MaxWayMenuEn());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDD25 Stock")) {
            sendMessage.setText("There are currently no promotions");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("ℹ about Us")) {
            sendMessage.setText("\uD83C\uDF5F MaxWay \n ☎️ Contact Center 998738487");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDCDE Contact us")) {
            sendMessage.setText("Contact us via @Bilolceek or call +998998738487.");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDD27 Settings")) {
            sendMessage.setText("Language settings");
            sendMessage.setReplyMarkup(KeyboardButtonUtilEn.nastroykaMenuEn());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83C\uDFE0 My addresses")) {
            sendMessage.setText("You have not yet added an address");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDCE5 Shopping")) {
            if (fastFoodList.size() == 0) {
                sendMessage.setText("The basket is empty");
            } else {
                StringBuilder builder = new StringBuilder();
                int count = 0;
                for (FastFood fastFood : fastFoodList) {
                    count++;
                    if (fastFood.getUser().getId().equals(user.getId())) {
                        builder.append("Food: ").append(fastFood.getName()).append("\n");
                        builder.append("Rate: ").append(fastFood.getAmount()).append("\n");
                        builder.append("Count: ").append(fastFood.getCount()).append("\n");
                        builder.append("\n---------------------\n");
                        if (count == fastFoodList.size()) {
                            builder.append("All: ").append(amount);
                        }
                    }
                    ComponentContainer.countOrders += fastFood.getCount();
                    if (builder.toString().isEmpty()) {
                        builder.append("The basket is empty !");
                    }
                }
                ComponentContainer.allAmount += amount;
                sendMessage.setText(builder.toString());
                sendMessage.setReplyMarkup(KeyboardButtonUtilEn.savatEn());
            }
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.contains("\uD83C") || text.contains("\uD83E")) {
            ComponentContainer.orderControllerEn.ordersEn(user, message);
            sendMessage.setText("Select a category!");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else {
            sendMessage.setText("There is no such thing");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        }
    }

    public void handlePhotoEn(User user, Message message) {
        log_photoEn(user, message.getPhoto());
        SendMessage sendMessage = new SendMessage();
        String s = message.getText();
        sendMessage.setChatId(String.valueOf(user.getId()));
        sendMessage.setText("Accepted." + s);
        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        String newphoto = message.getPhoto().get(message.getPhoto().size() - 1).getFileId();
        ComponentContainer.photoMap.put(message.getText(), newphoto);
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(user.getId()));
        sendPhoto.setPhoto(new InputFile(newphoto));
        sendPhoto.setCaption(user.getFirstName());
        ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
        ComponentContainer.userStatusMap.remove(user.getId());
    }

    private void log_photoEn(User user, List<PhotoSize> photoSizeList) {
        String str = String.format(LocalDateTime.now() + ",  userId: %d, firstName: %s, lastName: %s",
                user.getId(), user.getFirstName(), user.getLastName());
        System.out.println(str);
        for (PhotoSize photo : photoSizeList) {
            System.out.println("FileID: " + photo.getFileId() + " Width: " + photo.getWidth() + " Height: " + photo.getHeight());
        }
    }

    public void handleVideoEn(User user, Message message) {
        Video video = message.getVideo();
        System.out.println("Video Upload: " + video.getFileId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(user.getId()));
        sendMessage.setText("Accepted");
        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);

        SendVideo sendVideo = new SendVideo();
        sendVideo.setChatId(ComponentContainer.ADMIN);
        sendVideo.setVideo(new InputFile(video.getFileId()));
        sendVideo.setCaption(user.getFirstName());
        ComponentContainer.MY_TELEGRAM_BOT.send(sendVideo);
    }

    public void handleContact(Message message) {
        Contact contact = message.getContact();
        System.out.println(contact.getFirstName() + " " + contact.getPhoneNumber());
        SendMessage toUser = new SendMessage();
        toUser.setChatId(String.valueOf(message.getChatId()));
        toUser.setReplyMarkup(KeyboardButtonUtilEn.locationEn());
        toUser.setText("Accepted\n\nSend your location ");
        ComponentContainer.MY_TELEGRAM_BOT.send(toUser);
        ComponentContainer.contactMap.put(contact.getUserId(), contact);
        ComponentContainer.userStatusMap.remove(message.getContact().getUserId());
    }

    public void handleLocationEn(User user, Message message) {
        if (ComponentContainer.contactMap.containsKey(user.getId())) {
            Contact contact = ComponentContainer.contactMap.get(user.getId());
            Location location = message.getLocation();
            System.out.println(user.getFirstName() + " " + location.getLatitude() + " " + location.getLongitude());
            SendMessage toUser = new SendMessage();
            toUser.setReplyMarkup(KeyboardButtonUtilEn.asosiyMenuEn());
            toUser.setChatId(String.valueOf(user.getId()));
            toUser.setText("Accepted" + "\nThank you for your purchase");
            ComponentContainer.MY_TELEGRAM_BOT.send(toUser);
            SendMessage toKurier = new SendMessage();
            toKurier.setChatId(ComponentContainer.Kurier);
            toKurier.setParseMode("HTML");

            StringBuilder builder1 = new StringBuilder();
            for (FastFood fastFood : fastFoodList) {
                if (fastFood.getUser().getId().equals(user.getId())) {
                    builder1.append("Food: ").append(fastFood.getName()).append("\n");
                    builder1.append("Rate: ").append(fastFood.getAmount()).append("\n");
                    builder1.append("Count: ").append(fastFood.getCount()).append("\n");
                    builder1.append("\n---------------------\n");
                }
            }

            String builder = "<a href=\"https://maps.google.com/?q=" +
                    location.getLatitude() +
                    "," +
                    location.getLongitude() +
                    "\"" +
                    ">User Location</a>";
            if (amount != 0) {
                builder1.append(contact.getFirstName()).append(" +").append(contact.getPhoneNumber()).append("\n");
                builder1.append("All: ").append(amount);
                StringBuilder builder2 = new StringBuilder("Sotilgan FastFoodlar soni: " + ComponentContainer.countOrders + "\nUlarning Jami Narxlari: " + ComponentContainer.allAmount + ".");
                SendMessage toAdmin = new SendMessage();
                toAdmin.setChatId(ComponentContainer.ADMIN);
                toAdmin.setText(String.valueOf(builder2));
                ComponentContainer.MY_TELEGRAM_BOT.send(toAdmin);
            }

            toKurier.setText("User: " + user.getFirstName() + " @" + user.getUserName() + "\n" + builder + "\n" + builder1);
            ComponentContainer.MY_TELEGRAM_BOT.send(toKurier);

            SendLocation sendLocation = new SendLocation();
            sendLocation.setLatitude(location.getLatitude());
            sendLocation.setLongitude(location.getLongitude());
            sendLocation.setChatId((ComponentContainer.Kurier));
            ComponentContainer.MY_TELEGRAM_BOT.send(sendLocation);
            fastFoodList.clear();
            amount = 0;
        }
    }

    private static void messageToAdminEn(User user) {
        if (!ComponentContainer.userMap.containsKey(user.getId())) {
            SendMessage adminMessage = new SendMessage();
            adminMessage.setChatId(ComponentContainer.ADMIN);
            adminMessage.setText("Name: " + user.getFirstName() + " NikName:  @" + user.getUserName() + " joined bot.");
            ComponentContainer.userMap.put(user.getId(), user);
            ComponentContainer.MY_TELEGRAM_BOT.send(adminMessage);
        }
    }

    private static Contact checkPhoneEn(String text, User user) {
        if (text.startsWith("998")) {
            boolean t = false;
            if (text.length() == 12) {
                for (char i = 0; i < text.length(); i++) {
                    if (!Character.isDigit(text.charAt(i))) {
                        t = true;
                    }
                }
                if (!t) {
                    Contact contact = new Contact();
                    contact.setFirstName(user.getFirstName());
                    contact.setUserId(user.getId());
                    contact.setPhoneNumber(text);
                    return contact;
                }
            }
        }
        return null;
    }

    public void handleCallBack(User user, Message message, String text) {
    }
}
