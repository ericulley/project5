package com.ga.project5.wallets;

import javax.persistence.*;

@Entity
@Table
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long clientId;
    private Long coinId;
    private String coinSymbol;
    private Double amountOwned;

    // Constructor 1: All
    public Wallet(Long id, Long clientId, Long coinId, String coinSymbol, Double amountOwned) {
        this.id = id;
        this.clientId = clientId;
        this.coinId = coinId;
        this.coinSymbol = coinSymbol;
        this.amountOwned = amountOwned;
    }

    // Constructor 2: No id for DB
    public Wallet(Long clientId, Long coinId, String coinSymbol, Double amountOwned) {
        this.clientId = clientId;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
                ", clientId=" + clientId +
                ", coinId=" + coinId +
                ", coinSymbol='" + coinSymbol + '\'' +
                ", amountOwned=" + amountOwned +
                '}';
    }
}
