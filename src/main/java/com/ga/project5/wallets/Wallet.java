package com.ga.project5.wallets;

import javax.persistence.*;

@Entity(name = "Wallet")
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long client;
    private Long coinId;
    private String coinSymbol;
    private Double amountOwned;

    // Constructor 1: None
    public Wallet() {
    }

    // Constructor 2: All
    public Wallet(Long id, Long client, Long coinId, String coinSymbol, Double amountOwned) {
        this.id = id;
        this.client = client;
        this.coinId = coinId;
        this.coinSymbol = coinSymbol;
        this.amountOwned = amountOwned;
    }

    // Constructor 3: No id for DB
    public Wallet(Long client, Long coinId, String coinSymbol, Double amountOwned) {
        this.client = client;
        this.coinId = coinId;
        this.coinSymbol = coinSymbol;
        this.amountOwned = amountOwned;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getCoinId() {
        return coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

    public String getCoinSymbol() {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol) {
        this.coinSymbol = coinSymbol;
    }

    public Double getAmountOwned() {
        return amountOwned;
    }

    public void setAmountOwned(Double amountOwned) {
        this.amountOwned = amountOwned;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", clientId=" + client +
                ", coinId=" + coinId +
                ", coinSymbol='" + coinSymbol + '\'' +
                ", amountOwned=" + amountOwned +
                '}';
    }
}
