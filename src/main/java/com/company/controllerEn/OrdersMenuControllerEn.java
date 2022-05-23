package com.company.controllerEn;

import com.company.container.ComponentContainer;
import com.company.entty.FastFood;
import com.company.enums.UserStatus;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

public class OrdersMenuControllerEn {
    public void equalEn(User user, Message message) {
        String text = message.getText();
        SendMessage sendMessage = new SendMessage();
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        if(text.equals("Kombo N1 Klab Sendwoch")){
            sendMessage.setText("Kombo N1 Klab Sendwoch");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEY2IYxPcsGs_nObANf3jQElYdzMZBAAJduDEbX_7JSJ3weuGlSJkiAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Комбо №1 Клаб сэндвич с курицей\n" +
                    "\n" +
                    "Narx: 28000.0 so'm\n" +
                    "\n" +
                    "Информация: клаб-сендвич с курицей, картофель-фри, кола 0,5 л");
            ComponentContainer.currentFastFood = new FastFood("Kombo N1 Klab Sendwoch", 28000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Kombo N2 Shaurma")){
            sendMessage.setText("Shourma");
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEEGIYtlElFe6Aw4aKj5POpB-MP51VAAJguDEbX_7JSPR_cE1YgSxDAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Комбо №2  Шаурма\n" +
                    "\n" +
                    "Narx: 29000.0 so'm\n" +
                    "\n" +
                    "Информация: шаурма мясная classic, картофель-фри, кола 0,5 л");
            ComponentContainer.currentFastFood = new FastFood("Shourma", 29000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Kombo N3 Gampurger")){
            sendMessage.setText("Gampurger");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEZmIYxYQZd8W2oljtlZYoZ-zGkoziAAKRuDEbX_7JSOX0plyTmZYPAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Комбо №3 Гамбургер\n" +
                    "\n" +
                    "Narx: 30000.0 so'm\n" +
                    "\n" +
                    "Информация: гамбургер, картофель-фри, кола 0,5 л");
            ComponentContainer.currentFastFood = new FastFood("Gampurger", 30000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Kalb sendwich kurinniy")){
            sendMessage.setText("Kalb sendwich kurinniy");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEmmIYysit7HQvb0xRT8LFs-bk5Qh6AAKouDEbovXISAh9K3QEQ2KRAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Клаб Сэндвич Куриный\n" +
                    "\n" +
                    "Narx: 23000.0 so'm\n" +
                    "\n" +
                    "Информация: тостер хлеб, куриный шницель, свежие огурцы, помидоры, соус \"клаб\", сыр Хохланд, картофель фри");
            ComponentContainer.currentFastFood = new FastFood("Kalb sendwich kurinniy", 23000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Maks Burger")){
            sendMessage.setText("Maks Burger");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEnWIYy1UCC9MDZVvGtpiWQlNH2JocAAKquDEbX_7JSDfxypFFEchWAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Макс Бургер\n" +
                    "\n" +
                    "Narx: 31000.0 so'm\n" +
                    "\n" +
                    "Информация: булочка гамбургер, соленые огурцы, помидоры, 2 мясной котлеты, красный лук, айсберг, соус \"бургер\", сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Maks Burger", 31000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Chiz Burger")){
            sendMessage.setText("Chiz Burger");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEoGIYy3R-EstHSwqPJGsh3hhmyi9WAAKsuDEbX_7JSGBy8s7k7-NhAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Чизбургер.\n" +
                    "\n" +
                    "Narx: 21000.0 so'm\n" +
                    "\n" +
                    "Информация: булочка гамбургер, соленые огурцы, помидоры, мясная котлета, красный лук, айсберг, соус \"бургер\", сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Chiz Burger", 21000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Gam Burger")){
            sendMessage.setText("Gam Burger");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEo2IYy6f-ntGBeUVwRDiK-QaDmQsMAAKtuDEbX_7JSA4eb4qE5n30AQADAgADeQADIwQ"));
            sendPhoto.setCaption("Гамбургер.\n" +
                    "\n" +
                    "Narx: 19000.0 so'm\n" +
                    "\n" +
                    "Информация: булочка гамбургер, соленые огурцы, помидоры, мясная котлета, красный лук, айсберг, соус \"бургер\"");
            ComponentContainer.currentFastFood = new FastFood("Gam Burger", 19000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Donar blyudo Myasnoy")){
            sendMessage.setText("Donar blyudo Myasnoy");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEpmIYy-1AVMaLFd8rNiYMrtrUYnEDAAKxuDEbX_7JSDwu069dTMjTAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Донар блюдо Мясной\n" +
                    "\n" +
                    "Narx: 38000.0 so'm\n" +
                    "\n" +
                    "Информация: Говяжье донар-мясо, рис с кукурузой, картофель-фри, салат из красной капусты, томатный соус, турецкая лепешка");
            ComponentContainer.currentFastFood = new FastFood("Donar blyudo Myasnoy", 38000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Xaggi Myasnoy")){
            sendMessage.setText("Xaggi Myasnoy");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEqWIYzB4jwjdsjHvmz5pOq9HM3qseAAKyuDEbX_7JSB9TSNm0OHNiAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Хагги мясной\n" +
                    "\n" +
                    "Narx: 26000.0 so'm\n" +
                    "\n" +
                    "Информация:  Хагги булочка, говяжье мясо-донар, свежие огурцы, помидоры, латук, томатный соус, майонез, сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Xaggi Myasnoy", 26000, user);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Lavash Big")){
            sendMessage.setText("Lavash Big");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIErGIYzKxsGhMnX-DYu4wlGc3rn8wQAAKzuDEbX_7JSMy7AvI82yZsAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Лаваш Биг\n" +
                    "\n" +
                    "Narx: 22000.0 so'm\n" +
                    "\n" +
                    "Информация: лаваш, говяжье мясо-донар, свежие огурцы, помидор, чипсы, томатный соус, майонез");
            ComponentContainer.currentFastFood = new FastFood("Lavash Big", 22000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }else if(text.equals("Lavash s sirom Big")){
            sendMessage.setText("Lavash s sirom Big");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEr2IYzNN4_sAczAIdRwEccKa7n9oAA7S4MRtf_slI7_yyCOuP6KwBAAMCAAN5AAMjBA"));
            sendPhoto.setCaption("Лаваш с сыром Биг\n" +
                    "\n" +
                    "Narx: 24000.0 so'm\n" +
                    "\n" +
                    "Информация: лаваш, говяжье мясо-донар, свежие огурцы, помидор, чипсы, томатный соус, майонез, сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Lavash s sirom Big", 24000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }else if(text.equals("Mini Lavash")){
            sendMessage.setText("Mini Lavash");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIErGIYzKxsGhMnX-DYu4wlGc3rn8wQAAKzuDEbX_7JSMy7AvI82yZsAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Мини Лаваш\n" +
                    "\n" +
                    "Narx: 20000.0 so'm\n" +
                    "\n" +
                    "Информация: лаваш, говяжье мясо-донар, свежие огурцы, помидор, чипсы, томатный соус, майонез");
            ComponentContainer.currentFastFood = new FastFood("Mini Lavash", 20000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }else if(text.equals("Mini Lavash s sirom")){
            sendMessage.setText("Mini Lavash s sirom");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEr2IYzNN4_sAczAIdRwEccKa7n9oAA7S4MRtf_slI7_yyCOuP6KwBAAMCAAN5AAMjBA"));
            sendPhoto.setCaption("Мини Лаваш с сыром\n" +
                    "\n" +
                    "Narx: 22000.0 so'm\n" +
                    "\n" +
                    "Информация: лаваш, говяжье мясо-донар, свежие огурцы, помидор, чипсы, томатный соус, майонез, сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Mini Lavash s sirom", 22000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }else if(text.equals("Mini Lavash Kurinniy")){
            sendMessage.setText("Mini Lavash Kurinniy");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEsmIYzeggkn3d4uN-noP6OtlFM_NJAAK4uDEbX_7JSHhvytMh6mw9AQADAgADeQADIwQ"));
            sendPhoto.setCaption("Мини Лаваш Куриный\n" +
                    "\n" +
                    "Narx: 18000.0 so'm\n" +
                    "\n" +
                    " Информация: лаваш, куриное мясо-донар, свежие огурцы, помидоры, чипсы, томатный соус, майонез");
            ComponentContainer.currentFastFood = new FastFood("Mini Lavash Kurinniy", 18000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }else if(text.equals("Lavash Gobyajiy ostr/big")){
            sendMessage.setText("Lavash Gobyajiy ostr/big");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEtWIYzjUJduuNhhv1kV4rGO3nUlKsAAK5uDEbX_7JSAv0tf1eq5ARAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Лаваш говяжий остр/биг\n" +
                    "\n" +
                    "Narx: 22000.0 so'm\n" +
                    "\n" +
                    "Информация: лаваш, говяжье мясо-донар, свежие огурцы, помидор, чипсы, томатный соус, майонез, острый соус");
            ComponentContainer.currentFastFood = new FastFood("Lavash Gobyajiy ostr/big", 22000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }else if(text.equals("Lavash Kurinniy ostr/big")){
            sendMessage.setText("Lavash Kurinniy ostr/big");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIEuGIYznodZRISy1-ciSQqJqmHtYfsAAK6uDEbX_7JSLFqODd0QeP9AQADAgADeQADIwQ"));
            sendPhoto.setCaption("Лаваш куриный остр/биг\n" +
                    "\n" +
                    "Narx: 20000.0 so'm\n" +
                    "\n" +
                    "Информация: лаваш, куриное мясо-донар, свежие огурцы, помидор, чипсы, томатный соус, майонез, острый соус");
            ComponentContainer.currentFastFood = new FastFood("Lavash Kurinniy ostr/big", 20000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }else if(text.equals("Lavash Kurinniy Big")){
            sendMessage.setText("Lavash Kurinniy Big");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE02IYztVGoYtfsitQFOxDDx150i_1AAK7uDEbX_7JSCuFERuOrhkFAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Лаваш Куриный БИГ\n" +
                    "\n" +
                    "Narx: 20000.0 so'm\n" +
                    "\n" +
                    "Информация: лаваш, куриное мясо-донар, свежие огурцы, помидор, чипсы, томатный соус, майонез");
            ComponentContainer.currentFastFood = new FastFood("Lavash Kurinniy Big", 20000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }else if(text.equals("Lavash Kurinnniy Big c Sirom")){
            sendMessage.setText("Lavash Kurinnniy Big c Sirom");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE1mIYz2depObyv5MoD8UNFhxuZx5mAAK4uDEbX_7JSHhvytMh6mw9AQADAgADeQADIwQ"));
            sendPhoto.setCaption("Лаваш Куриный БИГ с сыром\n" +
                    "\n" +
                    "Narx: 22000.0 so'm\n" +
                    "\n" +
                    "Информация: лаваш, куриное мясо-донар, свежие огурцы, помидор, чипсы, томатный соус, майонез, сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Lavash Kurinnniy Big c Sirom", 22000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Mini Lavash Kurinniy s Sirom")){
            sendMessage.setText("Mini Lavash Kurinniy s Sirom");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE2WIYz5q_TKeuN_G6rboIMY2ruIFtAAK4uDEbX_7JSHhvytMh6mw9AQADAgADeQADIwQ"));
            sendPhoto.setCaption("Мини Лаваш Куриный с сыром\n" +
                    "\n" +
                    "Narx: 20000.0 so'm\n" +
                    "\n" +
                    "Информация: лаваш, куриное мясо-донар, свежие огурцы, помидор, чипсы, томатный соус, майонез, сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Mini Lavash Kurinniy s Sirom", 20000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }  else if(text.equals("Big Shaourma")){
            sendMessage.setText("Big Shaourma");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE3GIY0AxgNDF-9UvDta0SCdkpzErNAAK-uDEbX_7JSAq0Kkb7DqewAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Биг Шаурма\n" +
                    "\n" +
                    "Narx: 22000.0 so'm\n" +
                    "\n" +
                    "Информация: донар булочка, говяжье мясо-донар, свежие огурцы, помидоры,  томатный соус");
            ComponentContainer.currentFastFood = new FastFood("Big Shaourma", 22000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Big Shaurma Sirli")){
            sendMessage.setText("Big Shaurma Sirli");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE32IY0EDEOxdIqnxtfYQfkTphw3y8AAK_uDEbX_7JSPkxrCx-MhrDAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Биг Шаурма с сыром\n" +
                    "\n" +
                    "Narx: 24000.0 so'm\n" +
                    "\n" +
                    "Информация: донар булочка, говяжье мясо-донар, свежие огурцы, помидоры,  томатный соус, сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Big Shaurma Sirli", 24000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Mini Shaurma")){
            sendMessage.setText("Mini Shaurma");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE4mIY0HEcs3bPdQec1s9-Yme9uEIwAAK-uDEbX_7JSAq0Kkb7DqewAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Мини шаурма\n" +
                    "\n" +
                    "Narx: 20000.0 so'm\n" +
                    "\n" +
                    "Информация: донар булочка, говяжье мясо-донар, свежие огурцы, помидоры,  томатный соус");
            ComponentContainer.currentFastFood = new FastFood("Mini Shaurma", 20000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }/* else if(text.equals("")){
            sendMessage.setText("");
            sendPhoto.setPhoto(new InputFile(""));
            sendPhoto.setCaption("");
            FastFood fastFood = new FastFood("Shourma", 29000, user);
            ComponentContainer.currentFastFood = fastFood;

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } */else if(text.equals("Mini Shaurma Sirli")){
            sendMessage.setText("Mini Shaurma Sirli");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE5WIY0LEyxejpDiVkt_PQTf5f1NtlAAK_uDEbX_7JSPkxrCx-MhrDAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Мини  Шаурма с сыром\n" +
                    "\n" +
                    "Narx: 22000.0 so'm\n" +
                    "\n" +
                    "Информация: донар булочка, говяжье мясо-донар, свежие огурцы, помидоры,  томатный соус, сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Mini Shaurma Sirli", 22000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Shaurma Kurinniy Sirli Mini")){
            sendMessage.setText("Shaurma Kurinniy Sirli Mini");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE62IY0Th1qiQp6fRfcaBFzqwiprrlAALCuDEbX_7JSPmv9PEax-gMAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Шаурма Куриный с сыром мини\n" +
                    "\n" +
                    "Narx: 20000.0 so'm\n" +
                    "\n" +
                    "Информация: донар булочка, куриное мясо-донар, свежие огурцы, помидор, томатный соус, сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("Shaurma Kurinniy Sirli", 20000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Shaurma Kurinnaya Mini")){
            sendMessage.setText("Shaurma Kurinnaya Mini");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE6GIY0Nd9MKNwHGYr3yY8wnlGTeu2AALBuDEbX_7JSA8ENi9yQW23AQADAgADeQADIwQ"));
            sendPhoto.setCaption("Шаурма Куриная мини\n" +
                    "\n" +
                    "Narx: 18000.0 so'm\n" +
                    "\n" +
                    "Информация: донар булочка, куриное мясо-донар, свежие огурцы, помидор, томатный соус");
            ComponentContainer.currentFastFood = new FastFood("Shaurma Kurinnaya Mini", 18000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Kartofel po-derevenski")){
            sendMessage.setText("Kartofel po-derevenski");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE7mIY0YtQd49bDPmaUy_PNTTfdPABAALDuDEbX_7JSHs1mKO9S1UhAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Картофель по-деревенски\n" +
                    "\n" +
                    "Narx: 11000.0 so'm\n" +
                    "\n" +
                    "Информация: Картофель по-деревенски");
            ComponentContainer.currentFastFood = new FastFood("Kartofel po-derevenski", 11000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("King Dog")){
            sendMessage.setText("King Dog");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE8WIY0dmOn-8YAtSB7imjb0UBwuCTAALEuDEbX_7JSA-jDEGRYYHeAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Кинг Дог\n" +
                    "\n" +
                    "Narx: 16000.0 so'm\n" +
                    "\n" +
                    "Информация: булочка хот-дог, сосиски Ширин, свежие огурцы, помидоры, айсберг, сыр Хохланд");
            ComponentContainer.currentFastFood = new FastFood("King Dog", 16000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Xot Dog")){
            sendMessage.setText("Xot Dog");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE9GIY0hzLb3sHQNHDWsxnexd1aniyAALFuDEbX_7JSFDma7hjMoYLAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Хот Дог\n" +
                    "\n" +
                    "Narx: 11000.0 so'm\n" +
                    "\n" +
                    "Информация: булочка хот-дог, канадская сосиска, свежие огурцы, помидоры, айсберг, соус \"хот-дог\"");
            ComponentContainer.currentFastFood = new FastFood("Xot Dog", 11000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Ris")){
            sendMessage.setText("Ris");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE92IY0pnU1bPEfPlIiVMAAbMJ18dC3AACx7gxG1_-yUg6TrgyXkhAOQEAAwIAA3kAAyME"));
            sendPhoto.setCaption("Рис\n" +
                    "\n" +
                    "Narx: 7000.0 so'm\n" +
                    "\n" +
                    "Информация: рис с кукурузой");
            ComponentContainer.currentFastFood = new FastFood("Ris", 7000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Salat is Krasniy Kapustiy")){
            sendMessage.setText("Salat is Krasniy Kapustiy");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE-mIY0rdASYb-2kj0_pev2oZyHbJpAALIuDEbX_7JSCQ9S376WeWzAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Салат из красной капусты\n" +
                    "\n" +
                    "Narx: 7000.0 so'm\n" +
                    "\n" +
                    "Информация: Свежая красная капуста, зелень, морковь, лимонный сок");
            ComponentContainer.currentFastFood = new FastFood("Salat is Krasniy Kapustiy", 7000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Stakan dlya chaya")){
            sendMessage.setText("Stakan dlya chaya");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE_WIY0uza4kUFS0jG-d9hCkFu9FWRAALJuDEbX_7JSBQq0AkGdUVyAQADAgADeAADIwQ"));
            sendPhoto.setCaption("Стакан для чая\n" +
                    "\n" +
                    "Narx: 500.0 so'm\n" +
                    "\n" +
                    "Информация/Ma'lumot: Стакан для чая");
            ComponentContainer.currentFastFood = new FastFood("Stakan dlya chaya", 500, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Pepsi 1,5")){
            sendMessage.setText("Pepsi 1,5");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFAAFiGNNQrSkjByvSkywOMIKX725l9wACyrgxG1_-yUj_5JQCZnZvuQEAAwIAA3kAAyME"));
            sendPhoto.setCaption("Пепси 1,5\n" +
                    "\n" +
                    "Narx: 15000.0 so'm\n" +
                    "\n" +
                    "Информация: Пепси 1,5 л");
            ComponentContainer.currentFastFood = new FastFood("Pepsi 1,5", 15000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Pepsi 1")){
            sendMessage.setText("Pepsi 1");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFAAFiGNNQrSkjByvSkywOMIKX725l9wACyrgxG1_-yUj_5JQCZnZvuQEAAwIAA3kAAyME"));
            sendPhoto.setCaption("Пепси 1\n" +
                    "\n" +
                    "Narx: 10000.0 so'm\n" +
                    "\n" +
                    "Информация: Пепси 1 л");
            ComponentContainer.currentFastFood = new FastFood("Pepsi 1", 10000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Pepsi 0,5")){
            sendMessage.setText("Pepsi 0,5");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFA2IY02Wf0mGLRaTjv_Xli0CpzyluAALKuDEbX_7JSP_klAJmdm-5AQADAgADeQADIwQ"));
            sendPhoto.setCaption("Пепси 0,5\n" +
                    "\n" +
                    "Narx: 7000.0 so'm\n" +
                    "\n" +
                    "Информация: Пепси 0,5 л");
            ComponentContainer.currentFastFood = new FastFood("Pepsi 0,5", 7000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Soki v assortimente")){
            sendMessage.setText("Soki v assortimente");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFBmIY073TGvDdfdy0qyUrWwPtgy6TAALLuDEbX_7JSH9wVyhR7unOAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Соки в ассортименте 1л\n" +
                    "\n" +
                    "Narx: 15000.0 so'm\n" +
                    "\n" +
                    "Информация: соки в ассортименте 1л");
            ComponentContainer.currentFastFood = new FastFood("Soki v assortimente", 15000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Voda 0,33")){
            sendMessage.setText("Voda 0,33");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFCWIY0-UpXTh0L5vhlDxgWVSCkHHVAALNuDEbX_7JSCKSmo5SVr2xAQADAgADeAADIwQ"));
            sendPhoto.setCaption("Вода 0,33л\n" +
                    "\n" +
                    "Narx: 2000.0 so'm\n" +
                    "\n" +
                    "Вода 0,33л");
            ComponentContainer.currentFastFood = new FastFood("Вода 0,33л", 2000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Mini voda 0,5")){
            sendMessage.setText("Mini voda 0,5");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFCWIY0-UpXTh0L5vhlDxgWVSCkHHVAALNuDEbX_7JSCKSmo5SVr2xAQADAgADeAADIwQ"));
            sendPhoto.setCaption("Мин/вода 0,5\n" +
                    "\n" +
                    "Narx: 2000.0 so'm\n" +
                    "\n" +
                    "Информация: Минеральная вода 0,3 л");
            ComponentContainer.currentFastFood = new FastFood("Mini voda 0,5", 2000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Odnorazoviy Stakan")){
            sendMessage.setText("Odnorazoviy Stakan");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIE_WIY0uza4kUFS0jG-d9hCkFu9FWRAALJuDEbX_7JSBQq0AkGdUVyAQADAgADeAADIwQ"));
            sendPhoto.setCaption("Одноразовый стакан\n" +
                    "\n" +
                    "Narx: 500.0 so'm\n" +
                    "\n" +
                    "Одноразовый стакан");
            ComponentContainer.currentFastFood = new FastFood("Odnorazoviy Stakan", 500, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Medovik")){
            sendMessage.setText("Medovik");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFDGIY1ZmhvQMyR4rLEwABTbBvy76oswAC0LgxG1_-yUgAAZ-vzXnWoDgBAAMCAAN5AAMjBA"));
            sendPhoto.setCaption("Медовик\n" +
                    "\n" +
                    "Narx: 16000.0 so'm\n" +
                    "\n" +
                    "Информация: Медовик");
            ComponentContainer.currentFastFood = new FastFood("Medovik", 16000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Snikers Muss")){
            sendMessage.setText("Snikers Muss");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFDGIY1ZmhvQMyR4rLEwABTbBvy76oswAC0LgxG1_-yUgAAZ-vzXnWoDgBAAMCAAN5AAMjBA"));
            sendPhoto.setCaption("Сникерс мусс\n" +
                    "\n" +
                    "Narx: 16000.0 so'm\n" +
                    "\n" +
                    "Информация: Сникерс мусс");
            ComponentContainer.currentFastFood = new FastFood("Snikers Muss", 16000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Chizneyk")){
            sendMessage.setText("Chizneyk");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFDGIY1ZmhvQMyR4rLEwABTbBvy76oswAC0LgxG1_-yUgAAZ-vzXnWoDgBAAMCAAN5AAMjBA"));
            sendPhoto.setCaption("Чизкейк\n" +
                    "\n" +
                    "Narx: 16000.0 so'm\n" +
                    "\n" +
                    "Информация: Чизкейк");
            ComponentContainer.currentFastFood = new FastFood("Chizneyk", 16000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Naggesti 20 ta")){
            sendMessage.setText("Naggesti 20 ta");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFFGIY5XPte_4cSFtaolp-G5k_1-ZQAAL5uDEbX_7JSKwlTCW0E1wzAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Наггетсы 20 шт\n" +
                    "\n" +
                    "Narx: 29000.0 so'm\n" +
                    "\n" +
                    "Информация: наггетсы 20 шт");
            ComponentContainer.currentFastFood = new FastFood("Naggesti 20 ta", 29000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Naggesti 12 ta")){
            sendMessage.setText("Naggesti 12 ta");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFFGIY5XPte_4cSFtaolp-G5k_1-ZQAAL5uDEbX_7JSKwlTCW0E1wzAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Нагетсы 12шт\n" +
                    "\n" +
                    "Narx: 19000.0 so'm\n" +
                    "\n" +
                    "Информация: наггетсы 12 шт");
            ComponentContainer.currentFastFood = new FastFood("Naggesti 12 ta", 19000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Naggesti 9 ta")){
            sendMessage.setText("Naggesti 9 ta");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFFGIY5XPte_4cSFtaolp-G5k_1-ZQAAL5uDEbX_7JSKwlTCW0E1wzAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Нагетсы 9шт\n" +
                    "\n" +
                    "Narx: 15000.0 so'm\n" +
                    "\n" +
                    "Информация: наггетсы 9 шт");
            ComponentContainer.currentFastFood = new FastFood("Naggesti 9 ta", 15000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Naggesti 6 ta")){
            sendMessage.setText("Naggesti 6 ta");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFFGIY5XPte_4cSFtaolp-G5k_1-ZQAAL5uDEbX_7JSKwlTCW0E1wzAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Нагетсы 6шт\n" +
                    "\n" +
                    "Narx: 11000.0 so'm\n" +
                    "\n" +
                    "Информация: наггетсы 6 шт");
            ComponentContainer.currentFastFood = new FastFood("Naggesti 6 ta", 11000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Kartofel Fri 60g")){
            sendMessage.setText("Kartofel Fri 60g");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFF2IY5ZNyR8W8JvZ4O2ABq38PPNe_AAL6uDEbX_7JSGCvDq67v00bAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Картофель Фри 60гр\n" +
                    "\n" +
                    "Narx: 7000.0 so'm\n" +
                    "\n" +
                    "Информация: картофель-фри");
            ComponentContainer.currentFastFood = new FastFood("Kartofel Fri 60g", 7000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Kartofel Fri")){
            sendMessage.setText("Kartofel Fri");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFF2IY5ZNyR8W8JvZ4O2ABq38PPNe_AAL6uDEbX_7JSGCvDq67v00bAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Картофель Фри.\n" +
                    "\n" +
                    "Narx: 11000.0 so'm\n" +
                    "\n" +
                    "Информация: картофель-фри");
            ComponentContainer.currentFastFood = new FastFood("Kartofel Fri", 11000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Ketchup 1 ta")){
            sendMessage.setText("Ketchup 1 ta");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFGmIY5oJkrtSkq4IW0aZDtUe8Ta__AAO5MRtf_slIi3W0AtURiaUBAAMCAAN5AAMjBA"));
            sendPhoto.setCaption("Кетчуп 1шт\n" +
                    "\n" +
                    "Narx: 1000.0 so'm\n" +
                    "\n" +
                    "Информация: Кетчуп соус");
            ComponentContainer.currentFastFood = new FastFood("Ketchup 1 ta", 1000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Mayonez 1 ta")){
            sendMessage.setText("Mayonez 1 ta");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFHWIY5pe5jXhEl07PlWIUAVZNEcYNAAIBuTEbX_7JSM1IpQ14siVeAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Майонез 1шт\n" +
                    "\n" +
                    "Narx: 1000.0 so'm\n" +
                    "\n" +
                    "Информация: Майонез соус");
            ComponentContainer.currentFastFood = new FastFood("Mayonez 1 ta", 1000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Chesnochniy Sous 20g")){
            sendMessage.setText("Chesnochniy Sous 20g");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFI2IY5sam7wiXjCt1RrdVk5TpsPUWAAIDuTEbX_7JSB_x7ZKNICWXAQADAgADeQADIwQ"));
            sendPhoto.setCaption("Чесночный соус 20гр\n" +
                    "\n" +
                    "Narx: 1000.0 so'm\n" +
                    "\n" +
                    "Информация: Чесночный соус");
            ComponentContainer.currentFastFood = new FastFood("Chesnochniy Sous 20g", 1000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        } else if(text.equals("Chili sous 30g")){
            sendMessage.setText("Chili sous 30g");
            sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIFIGIY5rNIkWaYGK4iK5xiqezlv1MNAAICuTEbX_7JSOUQu9NsWSo5AQADAgADeQADIwQ"));
            sendPhoto.setCaption("Чили Соус 30гр\n" +
                    "\n" +
                    "Narx: 1000.0 so'm\n" +
                    "\n" +
                    "Информация: Чили соус");
            ComponentContainer.currentFastFood = new FastFood("Chili sous 30g", 1000, user);

            ComponentContainer.MY_TELEGRAM_BOT.send(sendPhoto);
            ComponentContainer.MY_TELEGRAM_BOT.send(sendMessage);
            ComponentContainer.userStatusMap.put(user.getId(), UserStatus.ORDERS_NUM);
        }
    }
}
