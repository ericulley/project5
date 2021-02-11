package com.ga.project5.coin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    @Transactional
    public void updateCoin(long coinId, Coin coinData, Double purchaseAmount, Double currentPrice) {
        coinData.setId(coinId);

        if (purchaseAmount != null) {
            coinData.setPurchaseAmount(purchaseAmount);
        }

        if (currentPrice != null) {
            coinData.setCurrentPrice(currentPrice);
        }

        coinRepository.save(coinData);
    }
}
