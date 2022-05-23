package com.company.entty;

import org.telegram.telegrambots.meta.api.objects.User;

public class FastFood {
    private String name;
    private double amount;
    private int count;
    private User user;

    public FastFood(String name, double amount, User user) {
        this.name = name;
        this.amount = amount;
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FastFood{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
