package com.standalone.mystocks.models;

import java.io.Serializable;
import java.util.Comparator;

public class Stock implements Serializable, Comparable<Stock> {

    @Override
    public int compareTo(Stock other) {
        return other.getDate().compareTo(this.getDate());
    }

    public enum OrderType {
        BUY, SELL
    }

    int id;
    String symbol;
    double price;
    int shares;
    double profit;
    OrderType order;
    String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrderType getOrder() {
        return order;
    }

    public void setOrder(OrderType order) {
        this.order = order;
    }


}
