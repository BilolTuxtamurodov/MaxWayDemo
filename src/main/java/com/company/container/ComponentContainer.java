package com.company.container;

import com.company.MyTelegramBot;
import com.company.controller.MainController;
import com.company.controller.OrderController;
import com.company.controller.OrdersMenuController;
import com.company.controllerEn.MainControllerEn;
import com.company.controllerEn.OrderControllerEn;
import com.company.controllerEn.OrdersMenuControllerEn;
import com.company.controllerRu.MainControllerRu;
import com.company.controllerRu.OrderControllerRu;
import com.company.controllerRu.OrdersMenuControllerRu;
import com.company.entty.FastFood;
import com.company.enums.LanguageStatus;
import com.company.enums.UserStatus;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.HashMap;
import java.util.Map;

public class ComponentContainer {
    public static OrdersMenuController ORDER_MENU_CONTROLLER = new OrdersMenuController();
    public static OrdersMenuControllerRu ORDER_MENU_CONTROLLER_RU = new OrdersMenuControllerRu();
    public static OrdersMenuControllerEn ORDER_MENU_CONTROLLER_EN = new OrdersMenuControllerEn();
    public static Map<String, String> photoMap = new HashMap<>();
    public static MyTelegramBot MY_TELEGRAM_BOT;
    public static final String ADMIN = "1056262092";
    public static final String Kurier = "704807879";
    public static Map<Long, User> userMap = new HashMap<>();
    public static Map<Long, UserStatus> userStatusMap = new HashMap<>();
    public static OrderController orderController = new OrderController();
    public static OrderControllerRu orderControllerRu = new OrderControllerRu();
    public static FastFood currentFastFood;
    public static Map<Long, Contact> contactMap = new HashMap<>();
    public static Map<Long, LanguageStatus> languageStatusMap = new HashMap<>();
    public static MainController mainController = new MainController();
    public static MainControllerRu mainControllerRu = new MainControllerRu();
    public static MainControllerEn mainControllerEn = new MainControllerEn();
    public static OrderControllerEn orderControllerEn = new OrderControllerEn();
    public static int countOrders = 0;
    public static double allAmount = 0;

}
