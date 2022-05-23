package com.company.controller;

import com.company.container.ComponentContainer;
import com.company.entty.FastFood;
import com.company.enums.UserStatus;
import com.company.util.KeyboardButtonUtil;
import com.company.util.KeyboardButtonUtilRu;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class MainController {
    private List<FastFood> fastFoodList = new LinkedList<>();
    private LanguageController languageController = new LanguageController();
    private static double amount = 0;


    public void handleText(User user, Message message) {
        String text = message.getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if (text.equals("\uD83D\uDD04 Tilni o'zgartirish")) {
            sendMessage.setText("Tilni Tanlang");
            sendMessage.setReplyMarkup(KeyboardButtonUtilRu.menuLenguageRu());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.languageStatusMap.remove(user.getId());
            fastFoodList.clear();
            amount = 0;
        } else if (text.equals("/start")) {
            ComponentContainer.languageStatusMap.remove(user.getId());
            languageController.handleText(user, message);
        } else if (text.equals("\uD83C\uDDFA\uD83C\uDDFF O'zbekcha")) {
            String builder = "Hush kelibsiz ! <b>" + user.getFirstName() + "</b>\n";
            sendMessage.setText(builder);
            sendMessage.setParseMode("HTML");
            sendMessage.setReplyMarkup(KeyboardButtonUtil.asosiyMenu());
            messageToAdmin(user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("♻️ Tozalash")) {
            fastFoodList.clear();
            amount = 0;
            sendMessage.setText("Tozalandi.");
            sendMessage.setReplyMarkup(KeyboardButtonUtil.MaxWayMenu());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDE98 Buyurtma Berish")) {
            sendMessage.setText("Iltimos Raqamingizni Jonating yoki (998xxxxxxx) Ko'rinishda Jo'nating");
            sendMessage.setReplyMarkup(KeyboardButtonUtil.contact());
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.PHONE_NUMBER);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("⬅ Orqaga")) {
            sendMessage.setText("Asosiy menu");
            sendMessage.setReplyMarkup(KeyboardButtonUtil.asosiyMenu());
            ComponentContainer.userStatusMap.remove(user.getId());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("◀️ Orqaga")) {
            sendMessage.setText("Buyurtmani davom ettiring");
            sendMessage.setReplyMarkup(KeyboardButtonUtil.MaxWayMenu());
            ComponentContainer.userStatusMap.remove(user.getId());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (ComponentContainer.userStatusMap.containsKey(user.getId())) {
            switch (ComponentContainer.userStatusMap.get(user.getId())) {
                case FOODS_MENU -> {
                    ComponentContainer.orderController.choiseNum(user, message);
                    ComponentContainer.userStatusMap.remove(user.getId());
                }
                case ORDERS_MENU -> {
                    ComponentContainer.ORDER_MENU_CONTROLLER.equal(user, message);
                    sendMessage.setText("Miqdorni tanlang: ");
                    sendMessage.setReplyMarkup(KeyboardButtonUtil.choiseNumMenu());
                    ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                    ComponentContainer.userStatusMap.remove(user.getId());
                    ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
                }
                case ASOSIY_MENU -> {
                    sendMessage.setText("Buyurtmani davom ettiring");
                    sendMessage.setReplyMarkup(KeyboardButtonUtil.MaxWayMenu());
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
                        sendMessage.setText("Buyurtmani davom ettiring");
                        sendMessage.setReplyMarkup(KeyboardButtonUtil.MaxWayMenu());
                        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                        ComponentContainer.userStatusMap.remove(user.getId());
                    }
                }
                case PHONE_NUMBER -> {
                    Contact contact = checkPhone(text, user);
                    if (contact != null) {
                        System.out.println(contact.getFirstName() + " " + contact.getPhoneNumber());
                        SendMessage toUser = new SendMessage();
                        toUser.setChatId(String.valueOf(message.getChatId()));
                        toUser.setReplyMarkup(KeyboardButtonUtil.location());
                        toUser.setText("Qabul Qilindi\n\nLocatsiyangizni Jonating ");
                        ComponentContainer.MY_TELEGRAM_BOT.send(toUser);
                        ComponentContainer.contactMap.put(contact.getUserId(), contact);
                        ComponentContainer.userStatusMap.remove(user.getId());
                    } else {
                        sendMessage.setText("Raqam Xato Kiritildi \nQaytadan Urinib Ko'ring");
                        sendMessage.setReplyMarkup(KeyboardButtonUtil.contact());
                        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                    }
                }
            }
        } else if (text.equals("\uD83D\uDE95 Buyurtma Berish")) {
            sendMessage.setParseMode("HTML");
            String builder = "<a href=\"https://telegra.ph/Tashkent-MaxWay-menu-10-03\">MaxWay Menu</a>";
            sendMessage.setText("Kategoriyani Tanlang\n" + builder);
            sendMessage.setReplyMarkup(KeyboardButtonUtil.MaxWayMenu());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDD25 Aksiya")) {
            sendMessage.setText("Ayni Payitda Aksiyalar Yo'q");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("ℹ Biz haqimizda")) {
            sendMessage.setText("\uD83C\uDF5F MaxWay \n ☎️ Aloqa Markazi 998738487");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDCDE Biz bilan Bog'lanish")) {
            sendMessage.setText("Biz bilan @Bilolceek orqali bog'laning yoki +998998738487 raqamiga qo'ng'iroq qiling.");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDD27 Sozlamalar")) {
            sendMessage.setText("Til sozlamalari");
            sendMessage.setReplyMarkup(KeyboardButtonUtil.nastroykaMenu());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83C\uDFE0 Mening manzillarim")) {
            sendMessage.setText("Siz Xali Manzil Qo'shmadingiz");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDCE5 Savat")) {
            if (fastFoodList.size() == 0) {
                sendMessage.setText("Savat bosh");
            } else {
                StringBuilder builder = new StringBuilder();
                int count = 0;
                for (FastFood fastFood : fastFoodList) {
                    count++;
                    if (fastFood.getUser().getId().equals(user.getId())) {
                        builder.append("Food: ").append(fastFood.getName()).append("\n");
                        builder.append("Narxi: ").append(fastFood.getAmount()).append("\n");
                        builder.append("Soni: ").append(fastFood.getCount()).append("\n");
                        builder.append("\n---------------------\n");
                        if (count == fastFoodList.size()) {
                            builder.append("Jami: ").append(amount);
                        }
                    }
                    ComponentContainer.countOrders += fastFood.getCount();
                    if (builder.toString().isEmpty()) {
                        builder.append("Savat Bosh !");
                    }
                    sendMessage.setText(builder.toString());
                }
                ComponentContainer.allAmount += amount;
                sendMessage.setReplyMarkup(KeyboardButtonUtil.savat());

            }
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.contains("\uD83C") || text.contains("\uD83E")) {
            ComponentContainer.orderController.orders(user, message);
            sendMessage.setText("Kategoriyani Tanlang!");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else {
            sendMessage.setText("Bunday narsa yo");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        }
    }

    public void handlePhoto(User user, Message message) {
        log_photo(user, message.getPhoto());
        SendMessage sendMessage = new SendMessage();
        String s = message.getText();
        sendMessage.setChatId(String.valueOf(user.getId()));
        sendMessage.setText("Qabul qilindi." + s);
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

    private void log_photo(User user, List<PhotoSize> photoSizeList) {
        String str = String.format(LocalDateTime.now() + ",  userId: %d, firstName: %s, lastName: %s",
                user.getId(), user.getFirstName(), user.getLastName());
        System.out.println(str);
        for (PhotoSize photo : photoSizeList) {
            System.out.println("FileID: " + photo.getFileId() + " Width: " + photo.getWidth() + " Height: " + photo.getHeight());
        }
    }

    public void handleVideo(User user, Message message) {
        Video video = message.getVideo();
        System.out.println("Video Upload: " + video.getFileId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(user.getId()));
        sendMessage.setText("Qabul qilindi");
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
        toUser.setReplyMarkup(KeyboardButtonUtil.location());
        toUser.setText("Qabul Qilindi\n\nLocatsiyangizni Jonating ");
        ComponentContainer.MY_TELEGRAM_BOT.send(toUser);
        ComponentContainer.contactMap.put(contact.getUserId(), contact);
        ComponentContainer.userStatusMap.remove(message.getContact().getUserId());
    }

    public void handleLocation(User user, Message message) {
        if (ComponentContainer.contactMap.containsKey(user.getId())) {
            Contact contact = ComponentContainer.contactMap.get(user.getId());
            Location location = message.getLocation();
            System.out.println(user.getFirstName() + " " + location.getLatitude() + " " + location.getLongitude());
            SendMessage toUser = new SendMessage();
            toUser.setReplyMarkup(KeyboardButtonUtil.asosiyMenu());
            toUser.setChatId(String.valueOf(user.getId()));
            toUser.setText("Qabul qilindi" + "\nHaridingiz Uchun Raxmat");
            ComponentContainer.MY_TELEGRAM_BOT.send(toUser);

            SendMessage toKurier = new SendMessage();
            toKurier.setChatId(ComponentContainer.Kurier);
            toKurier.setParseMode("HTML");

            StringBuilder builder1 = new StringBuilder();
            for (FastFood fastFood : fastFoodList) {
                if (fastFood.getUser().getId().equals(user.getId())) {
                    builder1.append("Food: ").append(fastFood.getName()).append("\n");
                    builder1.append("Narxi: ").append(fastFood.getAmount()).append("\n");
                    builder1.append("Soni: ").append(fastFood.getCount()).append("\n");
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
                builder1.append("Jami: ").append(amount);

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

    private static void messageToAdmin(User user) {
        if (!ComponentContainer.userMap.containsKey(user.getId())) {
            SendMessage adminMessage = new SendMessage();
            adminMessage.setChatId(ComponentContainer.ADMIN);
            adminMessage.setText("Name: " + user.getFirstName() + " NikName:  @" + user.getUserName() + " joined bot.");
            ComponentContainer.userMap.put(user.getId(), user);
            ComponentContainer.MY_TELEGRAM_BOT.send(adminMessage);
        }
    }

    private static Contact checkPhone(String text, User user) {
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
