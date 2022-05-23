package com.company.controllerRu;

import com.company.container.ComponentContainer;
import com.company.controller.LanguageController;
import com.company.entty.FastFood;
import com.company.enums.UserStatus;
import com.company.util.KeyboardButtonUtil;
import com.company.util.KeyboardButtonUtilRu;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class MainControllerRu {
    private List<FastFood> fastFoodList = new LinkedList<>();
    private LanguageController languageController = new LanguageController();
    private static double amount = 0;

    public void handleTextRu(User user, Message message) {
        String text = message.getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if(text.equals("\uD83D\uDD04 Изменить язык")){
            sendMessage.setText("Выберите язык");
            sendMessage.setReplyMarkup(KeyboardButtonUtilRu.menuLenguageRu());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.languageStatusMap.remove(user.getId());
            fastFoodList.clear();
            amount = 0;
        } else
        if(text.equals("/start")){
            ComponentContainer.languageStatusMap.remove(user.getId());
            languageController.handleText(user, message);
        } else
        if (text.equals("\uD83C\uDDF7\uD83C\uDDFA Русский")) {
            String builder = "Добро пожаловать ! <b>" + user.getFirstName() + "</b>\n";
            sendMessage.setText(builder);
            sendMessage.setParseMode("HTML");
            sendMessage.setReplyMarkup(KeyboardButtonUtilRu.asosiyMenuRu());
            messageToAdmin(user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        }
        else if (text.equals("♻️ Очистить")) {
            fastFoodList.clear();
            amount = 0;
            sendMessage.setText("Очищено.");
            sendMessage.setReplyMarkup(KeyboardButtonUtilRu.MaxWayMenuRu());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDE98 Заказ")) {
            sendMessage.setText("Отправьте или введите свой номер (998xxxxxxx)");
            sendMessage.setReplyMarkup(KeyboardButtonUtilRu.contactRu());
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.PHONE_NUMBER);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        }
        else if (text.equals("⬅ Назад")) {
            sendMessage.setText("Главное меню");
            sendMessage.setReplyMarkup(KeyboardButtonUtilRu.asosiyMenuRu());
            ComponentContainer.userStatusMap.remove(user.getId());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("◀️ Назад")) {
            sendMessage.setText("Продолжить заказ");
            sendMessage.setReplyMarkup(KeyboardButtonUtilRu.MaxWayMenuRu());
            ComponentContainer.userStatusMap.remove(user.getId());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (ComponentContainer.userStatusMap.containsKey(user.getId())) {
            switch (ComponentContainer.userStatusMap.get(user.getId())) {
                case FOODS_MENU -> {
                    ComponentContainer.orderControllerRu.choiseNumRu(user, message);
                    ComponentContainer.userStatusMap.remove(user.getId());
                }
                case ORDERS_MENU -> {
                    ComponentContainer.ORDER_MENU_CONTROLLER_RU.equalRu(user, message);
                    sendMessage.setText("Выберите количество: ");
                    sendMessage.setReplyMarkup(KeyboardButtonUtilRu.choiseNumMenuRu());
                    ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                    ComponentContainer.userStatusMap.remove(user.getId());
                    ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
                }
                case ASOSIY_MENU -> {
                    sendMessage.setText("Продолжить заказ");
                    sendMessage.setReplyMarkup(KeyboardButtonUtilRu.MaxWayMenuRu());
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
                        sendMessage.setText("Продолжить заказ");
                        sendMessage.setReplyMarkup(KeyboardButtonUtilRu.MaxWayMenuRu());
                        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                        ComponentContainer.userStatusMap.remove(user.getId());
                    }
                }
                case PHONE_NUMBER -> {
                    Contact contact = checkPhone(text, user);
                    if(contact != null){
                        System.out.println(contact.getFirstName() + " " + contact.getPhoneNumber());
                        SendMessage toUser = new SendMessage();
                        toUser.setChatId(String.valueOf(message.getChatId()));
                        toUser.setReplyMarkup(KeyboardButtonUtilRu.locationRu());
                        toUser.setText("Принятый\n\nОтправьте свое местоположение ");
                        ComponentContainer.MY_TELEGRAM_BOT.send(toUser);
                        ComponentContainer.contactMap.put(contact.getUserId(), contact);
                        ComponentContainer.userStatusMap.remove(user.getId());
                    } else {
                        sendMessage.setText("Номер был введен неправильно \nПопробуйте снова");
                        sendMessage.setReplyMarkup(KeyboardButtonUtilRu.contactRu());
                        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
                    }

                }
            }
        } else if (text.equals("\uD83D\uDE95 Заказ")) {
            sendMessage.setParseMode("HTML");
            String builder = "<a href=\"https://telegra.ph/Tashkent-MaxWay-menu-10-03\">MaxWay Menu</a>";
            sendMessage.setText("Выберите категорию\n" + builder);
            sendMessage.setReplyMarkup(KeyboardButtonUtilRu.MaxWayMenuRu());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDD25 Акция")) {
            sendMessage.setText("В настоящее время нет доступных акций");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("ℹ О нас")) {
            sendMessage.setText("\uD83C\uDF5F Макс Вэй \n ☎️  Контактный центр +998998738487");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDCDE Связаться с нами")) {
            sendMessage.setText("Свяжитесь с нами через @Bilolceek или позвоните по телефону +998998738487.");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDD27 Настройки")) {
            sendMessage.setText("Языковые настройки");
            sendMessage.setReplyMarkup(KeyboardButtonUtilRu.nastroykaMenuRu());
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83C\uDFE0 Мои адреса")) {
            sendMessage.setText("Вы еще не ввели адрес");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.equals("\uD83D\uDCE5 Корзина")) {
            if (fastFoodList.size() == 0) {
                sendMessage.setText("Корзина пуста");
            } else {
                StringBuilder builder = new StringBuilder();
                int count = 0;
                for (FastFood fastFood : fastFoodList) {
                    count++;
                    if (fastFood.getUser().getId().equals(user.getId())) {
                        builder.append("Еда: ").append(fastFood.getName()).append("\n");
                        builder.append("Цена: ").append(fastFood.getAmount()).append("сум").append("\n");
                        builder.append("Сколько: ").append(fastFood.getCount()).append("\n");
                        builder.append("\n---------------------\n");
                        if (count == fastFoodList.size()) {
                            builder.append("Итого: ").append(amount);
                        }
                    }
                    ComponentContainer.countOrders += fastFood.getCount();
                    if (builder.toString().isEmpty()) {
                        builder.append("Корзина пуста");
                    }
                }
                ComponentContainer.allAmount += amount;
                sendMessage.setText(builder.toString());
                sendMessage.setReplyMarkup(KeyboardButtonUtilRu.savatRu());
            }
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else if (text.contains("\uD83C") || text.contains("\uD83E")) {
            ComponentContainer.orderControllerRu.ordersRu(user, message);
            sendMessage.setText("Выберите категорию!");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        } else {
            sendMessage.setText("Введено неверное слово");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
        }
    }

    public void handlePhotoRu(User user, Message message) {
        log_photo(user, message.getPhoto());
        SendMessage sendMessage = new SendMessage();
        String s = message.getText();
        sendMessage.setChatId(String.valueOf(user.getId()));
        sendMessage.setText("Принятый." + s);
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

    public void handleVideoRu(User user, Message message) {
        Video video = message.getVideo();
        System.out.println("Загрузка видео: " + video.getFileId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(user.getId()));
        sendMessage.setText("Принятый");
        ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);

        SendVideo sendVideo = new SendVideo();
        sendVideo.setChatId(ComponentContainer.ADMIN);
        sendVideo.setVideo(new InputFile(video.getFileId()));
        sendVideo.setCaption(user.getFirstName());
        ComponentContainer.MY_TELEGRAM_BOT.send(sendVideo);
    }

    public void handleContactRu(Message message) {
        Contact contact = message.getContact();
        System.out.println(contact.getFirstName() + " " + contact.getPhoneNumber());
        SendMessage toUser = new SendMessage();
        toUser.setChatId(String.valueOf(message.getChatId()));
        toUser.setReplyMarkup(KeyboardButtonUtilRu.locationRu());
        toUser.setText("Принятый\n\nОтправьте свое местоположение ");
        ComponentContainer.MY_TELEGRAM_BOT.send(toUser);
        ComponentContainer.contactMap.put(contact.getUserId(), contact);
        ComponentContainer.userStatusMap.remove(message.getContact().getUserId());
        /*SendContact sendContact = new SendContact();
        sendContact.setFirstName(contact.getFirstName());
        sendContact.setLastName(contact.getLastName());
        sendContact.setPhoneNumber(contact.getPhoneNumber());
        sendContact.setChatId(ComponentContainer.ADMIN);
        ComponentContainer.MY_TELEGRAM_BOT.send(sendContact);*/
    }

    public void handleLocationRu(User user, Message message) {
        if(ComponentContainer.contactMap.containsKey(user.getId())) {
            Contact contact = ComponentContainer.contactMap.get(user.getId());
            Location location = message.getLocation();
            System.out.println(user.getFirstName() + " " + location.getLatitude() + " " + location.getLongitude());
            SendMessage toUser = new SendMessage();
            toUser.setReplyMarkup(KeyboardButtonUtilRu.asosiyMenuRu());
            toUser.setChatId(String.valueOf(user.getId()));
            toUser.setText("Принятый" + "\nСпасибо за покупку");
            ComponentContainer.MY_TELEGRAM_BOT.send(toUser);
            SendMessage toKurier = new SendMessage();
            toKurier.setChatId(ComponentContainer.Kurier);
            toKurier.setParseMode("HTML");

            StringBuilder builder1 = new StringBuilder();
            for (FastFood fastFood : fastFoodList) {
                if (fastFood.getUser().getId().equals(user.getId())) {
                    builder1.append("Еда: ").append(fastFood.getName()).append("\n");
                    builder1.append("Цена: ").append(fastFood.getAmount()).append("сум").append("\n");
                    builder1.append("Сколько: ").append(fastFood.getCount()).append("\n");
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
                builder1.append("Итого: ").append(amount).append("сум");

                StringBuilder builder2 = new StringBuilder("Sotilgan FastFoodlar soni: " + ComponentContainer.countOrders + "\nUlarning Jami Narxlari: " + ComponentContainer.allAmount + ".");
                SendMessage toAdmin = new SendMessage();
                toAdmin.setChatId(ComponentContainer.ADMIN);
                toAdmin.setText(String.valueOf(builder2));
                ComponentContainer.MY_TELEGRAM_BOT.send(toAdmin);
            }

            toKurier.setText("User: " + user.getFirstName() + " @" + user.getUserName() + "\n" + builder + "\n" + builder1.toString());
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

    private static void messageToAdmin(User user){
        if (!ComponentContainer.userMap.containsKey(user.getId())) {
            SendMessage adminMessage = new SendMessage();
            adminMessage.setChatId(ComponentContainer.ADMIN);
            adminMessage.setText("Name: " + user.getFirstName() + " NikName:  @" + user.getUserName() + " joined bot.");
            ComponentContainer.userMap.put(user.getId(), user);
            ComponentContainer.MY_TELEGRAM_BOT.send(adminMessage);
        }
    }

    private static Contact checkPhone(String text, User user){
        if(text.startsWith("998") ) {
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
