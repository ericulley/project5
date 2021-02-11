package com.ga.project5.coin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CoinController {

    private final CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/coins")
    public List<Coin> getCoins() {
        return coinService.getCoins();
    }

    @PostMapping("/coins")
    public List<Coin> createCoin(@RequestBody Coin coinData) {
        coinService.addNewCoin(coinData);
        return coinService.getCoins();
    }

    @DeleteMapping("/coins/{coinId}")
    public List<Coin> deleteCoin(@PathVariable Long coinId) {
        coinService.deleteCoin(coinId);
        return coinService.getCoins();
    }

    @PutMapping("/coins/{coinId}")
    public List<Coin> updateCoin(
            @PathVariable Long coinId,
            @RequestBody Coin coinData,
            @RequestParam(required = false) Double purchaseAmount,
            @RequestParam(required = false) Double currentPrice) {
        coinService.updateCoin(coinId, coinData, purchaseAmount, currentPrice);
        return coinService.getCoins();
    }
}
