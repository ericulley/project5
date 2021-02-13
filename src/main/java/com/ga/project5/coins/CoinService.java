package com.ga.project5.coins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public void addNewCoin(Coin coinData) {
        coinRepository.save(coinData);
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
