package com.company.util;

import com.company.container.ComponentContainer;
import com.company.enums.UserStatus;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.Arrays;
import java.util.List;

public class KeyboardButtonUtil {
    public static KeyboardButton button(String text) {
        return new KeyboardButton(text);
    }

    public static KeyboardButton buttonEmoji(String text, String emoji) {
        String emojiText = EmojiParser.parseToUnicode(emoji + " " + text);
        return new KeyboardButton(emojiText);
    }

    public static ReplyKeyboardMarkup asosiyMenu() {
        KeyboardButton button = KeyboardButtonUtil.buttonEmoji("Buyurtma Berish", ":taxi:");
        KeyboardButton button1 = KeyboardButtonUtil.buttonEmoji("Aksiya", ":fire:");
        KeyboardButton button2 = KeyboardButtonUtil.buttonEmoji("Biz haqimizda", ":information_source:");
        KeyboardButton button3 = KeyboardButtonUtil.buttonEmoji("Biz bilan Bog'lanish", ":telephone_receiver:");
        KeyboardButton button4 = KeyboardButtonUtil.buttonEmoji("Sozlamalar", ":wrench:");
        KeyboardButton button5 = KeyboardButtonUtil.buttonEmoji("Mening manzillarim", ":house:");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button1);
        row2.add(button2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button3);
        row3.add(button4);
        row3.add(button5);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup MaxWayMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", ":arrow_left:");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton kombo = KeyboardButtonUtil.buttonEmoji("Kombo", "\uD83E\uDD6A \uD83C\uDF5F \uD83E\uDD64");
        KeyboardButton kabsendwich = KeyboardButtonUtil.buttonEmoji("Klab Sendvich", "\uD83E\uDD6A");
        KeyboardButton burger = KeyboardButtonUtil.buttonEmoji("Burger", "\uD83C\uDF54");
        KeyboardButton donarBlyudo = KeyboardButtonUtil.buttonEmoji("Donar Blyudo", "\uD83C\uDF71");
        KeyboardButton lavash = KeyboardButtonUtil.buttonEmoji("Lavash", "\uD83C\uDF2F");
        KeyboardButton shourma = KeyboardButtonUtil.buttonEmoji("Shourma", "\uD83E\uDDC6");
        KeyboardButton cneki = KeyboardButtonUtil.buttonEmoji("Sneklar", "\uD83C\uDF5F");
        KeyboardButton xot_dog = KeyboardButtonUtil.buttonEmoji("Xot Dog", "\uD83C\uDF2D");
        KeyboardButton garniri = KeyboardButtonUtil.buttonEmoji("Garnirlar", "\uD83E\uDDC6");
        KeyboardButton napitki = KeyboardButtonUtil.buttonEmoji("Napitki", "\uD83E\uDD64\uD83E\uDD64");
        KeyboardButton deserti = KeyboardButtonUtil.buttonEmoji("Deserti", "\uD83C\uDF70");
        KeyboardButton sneki = KeyboardButtonUtil.buttonEmoji("Sneki", "\uD83C\uDF5F");
        KeyboardButton sousi = KeyboardButtonUtil.buttonEmoji("Souslar", "\uD83E\uDED5");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(kombo);
        row1.add(kabsendwich);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(burger);
        row2.add(donarBlyudo);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(lavash);
        row3.add(shourma);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(cneki);
        row4.add(xot_dog);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(garniri);
        row5.add(napitki);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(deserti);
        row6.add(sneki);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(sousi);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2, row3, row4, row5, row6, row7));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup komboMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton kombo_1 = KeyboardButtonUtil.button("Kombo N1 Klab Sendwoch");
        KeyboardButton kombo_2 = KeyboardButtonUtil.button("Kombo N2 Shaurma");
        KeyboardButton kombo_3 = KeyboardButtonUtil.button("Kombo N3 Gampurger");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(orqaga);
        row1.add(savat);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(kombo_1);
        row2.add(kombo_2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(kombo_3);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup choiseNumMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");

        KeyboardButton bir = KeyboardButtonUtil.button("1");
        KeyboardButton ikki = KeyboardButtonUtil.button("2");
        KeyboardButton uch = KeyboardButtonUtil.button("3");
        KeyboardButton tort = KeyboardButtonUtil.button("4");
        KeyboardButton besh = KeyboardButtonUtil.button("5");
        KeyboardButton olti = KeyboardButtonUtil.button("6");
        KeyboardButton yetti = KeyboardButtonUtil.button("7");
        KeyboardButton sakkiz = KeyboardButtonUtil.button("8");
        KeyboardButton toqqiz = KeyboardButtonUtil.button("9");
        KeyboardButton on = KeyboardButtonUtil.button("10");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(bir);
        row1.add(ikki);
        row1.add(uch);
        row1.add(tort);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(besh);
        row2.add(olti);
        row2.add(yetti);
        row2.add(sakkiz);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(toqqiz);
        row3.add(on);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2, row3));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;

    }

    public static ReplyKeyboardMarkup klabMenu(User user) {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton klabSendwich = KeyboardButtonUtil.button("Kalb sendwich kurinniy");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(klabSendwich);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1));
        replyKeyboardMarkup.setResizeKeyboard(true);
        ComponentContainer.userStatusMap.put(user.getId(), UserStatus.FOODS_MENU);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup burgerMenu(User user) {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton maksBurger = KeyboardButtonUtil.button("Maks Burger");
        KeyboardButton chizBurger = KeyboardButtonUtil.button("Chiz Burger");
        KeyboardButton gamBurger = KeyboardButtonUtil.button("Gam Burger");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(maksBurger);
        row1.add(chizBurger);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(gamBurger);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2));
        replyKeyboardMarkup.setResizeKeyboard(true);
        ComponentContainer.userStatusMap.put(user.getId(), UserStatus.FOODS_MENU);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup donarMenu(User user) {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton donarblyuMyasnoy = KeyboardButtonUtil.button("Donar blyudo Myasnoy");
        KeyboardButton xaggiMyasnoy = KeyboardButtonUtil.button("Xaggi Myasnoy");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(donarblyuMyasnoy);
        row1.add(xaggiMyasnoy);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1));
        replyKeyboardMarkup.setResizeKeyboard(true);
        ComponentContainer.userStatusMap.put(user.getId(), UserStatus.FOODS_MENU);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup lavashMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton lavashBig = KeyboardButtonUtil.button("Lavash Big");
        KeyboardButton lavashCiromBig = KeyboardButtonUtil.button("Lavash s sirom Big");
        KeyboardButton miniLavash = KeyboardButtonUtil.button("Mini Lavash");
        KeyboardButton miniLavashSirom = KeyboardButtonUtil.button("Mini Lavash s sirom");
        KeyboardButton lavashGovyajiy = KeyboardButtonUtil.button("Lavash Gobyajiy ostr/big");
        KeyboardButton lavashKurinniyOstr = KeyboardButtonUtil.button("Lavash Kurinniy ostr/big");
        KeyboardButton lavashKurinniyBig = KeyboardButtonUtil.button("Lavash Kurinniy Big");
        KeyboardButton lavashKurinniyBogSirom = KeyboardButtonUtil.button("Lavash Kurinnniy Big c Sirom");
        KeyboardButton miniLavashKurinniy = KeyboardButtonUtil.button("Mini Lavash Kurinniy");
        KeyboardButton miniLavashKurinniySirom = KeyboardButtonUtil.button("Mini Lavash Kurinniy s Sirom");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(lavashBig);
        row1.add(lavashCiromBig);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(miniLavash);
        row2.add(miniLavashSirom);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(lavashGovyajiy);
        row3.add(lavashKurinniyOstr);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(lavashKurinniyBig);
        row4.add(lavashKurinniyBogSirom);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(miniLavashKurinniy);
        row5.add(miniLavashKurinniySirom);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2, row3, row4, row5));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup shourmaMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton bigShourma = KeyboardButtonUtil.button("Big Shaourma");
        KeyboardButton bigShourmaSirom = KeyboardButtonUtil.button("Big Shaurma Sirli");
        KeyboardButton miniShourma = KeyboardButtonUtil.button("Mini Shaurma");
        KeyboardButton miniShourmaSirom = KeyboardButtonUtil.button("Mini Shaurma Sirli");
        KeyboardButton miniShourmaKurinniy = KeyboardButtonUtil.button("Shaurma Kurinnaya Mini");
        KeyboardButton shourmaKurinniySirom = KeyboardButtonUtil.button("Shaurma Kurinniy Sirli Mini");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(bigShourma);
        row1.add(bigShourmaSirom);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(miniShourma);
        row2.add(miniShourmaSirom);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(miniShourmaKurinniy);
        row3.add(shourmaKurinniySirom);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2, row3));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }


    public static ReplyKeyboardMarkup snekMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton kartofel = KeyboardButtonUtil.button("Kartofel po-derevenski");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(kartofel);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup xotDogMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton kingDog = KeyboardButtonUtil.button("King Dog");
        KeyboardButton xotDog = KeyboardButtonUtil.button("Xot Dog");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(kingDog);
        row1.add(xotDog);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;

    }

    public static ReplyKeyboardMarkup garnirMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton ris = KeyboardButtonUtil.button("Ris");
        KeyboardButton salatKrasniyKapusti = KeyboardButtonUtil.button("Salat is Krasniy Kapustiy");
        KeyboardButton stakanDlyaCHay = KeyboardButtonUtil.button("Stakan dlya chaya");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(ris);
        row1.add(salatKrasniyKapusti);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(stakanDlyaCHay);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup napitkiMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton pepsi1_5 = KeyboardButtonUtil.button("Pepsi 1,5");
        KeyboardButton pepsi1 = KeyboardButtonUtil.button("Pepsi 1");
        KeyboardButton pepsi0_5 = KeyboardButtonUtil.button("Pepsi 0,5");
        KeyboardButton soki = KeyboardButtonUtil.button("Soki v assortimente");
        KeyboardButton voda0_33 = KeyboardButtonUtil.button("Voda 0,33");
        KeyboardButton Mini_voda0_5 = KeyboardButtonUtil.button("Mini voda 0,5");
        KeyboardButton stakan = KeyboardButtonUtil.button("Odnorazoviy Stakan");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(pepsi1_5);
        row1.add(pepsi1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(pepsi0_5);
        row2.add(soki);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(voda0_33);
        row3.add(Mini_voda0_5);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(stakan);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2, row3, row4));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup desertMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton medovik = KeyboardButtonUtil.button("Medovik");
        KeyboardButton snikersMuss = KeyboardButtonUtil.button("Snikers Muss");
        KeyboardButton chizneyk = KeyboardButtonUtil.button("Chizneyk");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(medovik);
        row1.add(snikersMuss);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(chizneyk);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup snekii() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton naggesti20 = KeyboardButtonUtil.button("Naggesti 20 ta");
        KeyboardButton naggesti12 = KeyboardButtonUtil.button("Naggesti 12 ta");
        KeyboardButton naggesti9 = KeyboardButtonUtil.button("Naggesti 9 ta");
        KeyboardButton naggesiti6 = KeyboardButtonUtil.button("Naggesti 6 ta");
        KeyboardButton kartofelFree60 = KeyboardButtonUtil.button("Kartofel Fri 60g");
        KeyboardButton kartofelfre = KeyboardButtonUtil.button("Kartofel Fri");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(naggesti20);
        row1.add(naggesti12);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(naggesti9);
        row2.add(naggesiti6);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(kartofelFree60);
        row3.add(kartofelfre);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2, row3));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup sousiMenu() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton savat = KeyboardButtonUtil.buttonEmoji("Savat", ":inbox_tray:");
        KeyboardButton ketchup1 = KeyboardButtonUtil.button("Ketchup 1 ta");
        KeyboardButton mayonez1 = KeyboardButtonUtil.button("Mayonez 1 ta");
        KeyboardButton chesnochniysous = KeyboardButtonUtil.button("Chesnochniy Sous 20g");
        KeyboardButton chiliSous = KeyboardButtonUtil.button("Chili sous 30g");

        KeyboardRow row = new KeyboardRow();
        row.add(orqaga);
        row.add(savat);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(ketchup1);
        row1.add(mayonez1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(chesnochniysous);
        row2.add(chiliSous);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1, row2));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup savat() {
        KeyboardButton tozalash = KeyboardButtonUtil.buttonEmoji("Tozalash", "♻️");
        KeyboardButton buyurtma_berish = KeyboardButtonUtil.buttonEmoji("Buyurtma Berish", "\uD83D\uDE98");
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");

        KeyboardRow row = new KeyboardRow();
        row.add(tozalash);
        row.add(buyurtma_berish);
        row.add(orqaga);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(row));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup location() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton location = KeyboardButtonUtil.buttonEmoji("Location", "\uD83D\uDCCD");
        location.setRequestLocation(true);

        KeyboardRow row = new KeyboardRow();
        row.add(location);
        row.add(orqaga);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(row));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup contact() {
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", "◀️");
        KeyboardButton contact = KeyboardButtonUtil.buttonEmoji("Contact", "\uD83D\uDCF2");
        contact.setRequestContact(true);

        KeyboardRow row = new KeyboardRow();
        row.add(contact);
        row.add(orqaga);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(row));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup menuLenguage(){
        KeyboardButton uz = KeyboardButtonUtil.buttonEmoji("O'zbekcha", "\uD83C\uDDFA\uD83C\uDDFF");
        KeyboardButton ru = KeyboardButtonUtil.buttonEmoji("Русский", "\uD83C\uDDF7\uD83C\uDDFA");
        KeyboardButton en = KeyboardButtonUtil.buttonEmoji("English", "\uD83C\uDDF1\uD83C\uDDF7");

        KeyboardRow row = new KeyboardRow();
        row.add(uz);
        row.add(ru);
        row.add(en);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(row));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;

    }

    public static ReplyKeyboardMarkup nastroykaMenu(){
        KeyboardButton language = KeyboardButtonUtil.buttonEmoji("Tilni o'zgartirish", "\uD83D\uDD04");
        KeyboardButton orqaga = KeyboardButtonUtil.buttonEmoji("Orqaga", ":arrow_left:");

        KeyboardRow row = new KeyboardRow();
        row.add(language);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(orqaga);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row1));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }
}
