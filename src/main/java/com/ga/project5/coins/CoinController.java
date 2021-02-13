package com.ga.project5.coins;

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
            @RequestBody Coin reqBody) {
        System.out.println(coinId);
        System.out.println(reqBody);
        coinService.updateCoin(coinId, reqBody);
        return coinService.getCoins();
    }
}
