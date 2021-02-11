package com.ga.project5.coins;

import javax.persistence.*;

@Entity
@Table
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String symbol;
    private double purchasePrice;
    private double purchaseAmount;
    private double currentPrice;
    @Transient
    private double currentValue;

// Constructor 1
    public Coin() {
    }
// Constructor 2
    public Coin(Long id,
                String name,
                String symbol,
                double purchasePrice,
                double purchaseAmount,
                double currentPrice) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.purchasePrice = purchasePrice;
        this.purchaseAmount = purchaseAmount;
        this.currentPrice = currentPrice;
    }
//  Constructor 3: No id for DB
    public Coin(String name,
                String symbol,
                double purchasePrice,
                double purchaseAmount,
                double currentPrice) {
        this.name = name;
        this.symbol = symbol;
        this.purchasePrice = purchasePrice;
        this.purchaseAmount = purchaseAmount;
        this.currentPrice = currentPrice;
    }
//  Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getCurrentValue() {
        return this.currentPrice * this.purchaseAmount;
    }

//  toString
    @Override
    public String toString() {
        return "Coin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", purchaseAmount=" + purchaseAmount +
                ", currentPrice=" + currentPrice +
                ", currentValue=" + currentValue +
                '}';
    }
}