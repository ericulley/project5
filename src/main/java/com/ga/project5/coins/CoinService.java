package com.ga.project5.coins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinService {

    private final CoinRepository coinRepository;

    @Autowired
    public CoinService(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    public List<Coin> getCoins() {
        return coinRepository.findAll();
    }

    public Coin getACoin(Long id) {
        System.out.println("Service: " + id);
        return coinRepository.findCoinById(id);
    }

    public Coin addNewCoin(Coin coinData) {
        Optional<Coin> foundCoin = coinRepository.findOptionalCoinBySymbol(coinData.getSymbol());
        if (!foundCoin.isPresent()) {
            coinRepository.save(coinData);
        }
        Coin newCoin = coinRepository.findCoinBySymbol(coinData.getSymbol());
        return newCoin;
    }

    public void deleteCoin(Long coinId) {
        coinRepository.deleteById(coinId);
    }


    public void updateCoin(long coinId, Coin reqBody) {
        Coin coinToUpdate = coinRepository.getOne(coinId);
        System.out.println(coinToUpdate);
        coinToUpdate.setPurchaseAmount(reqBody.getPurchaseAmount());
        System.out.println(coinToUpdate);
        coinRepository.save(coinToUpdate);
    }
}
