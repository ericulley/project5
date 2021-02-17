package com.ga.project5.coins;

import com.ga.project5.wallets.Wallet;
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

    @GetMapping("/coins/{id}")
    public Coin getACoin(@PathVariable Long id) {
        System.out.println("Controller: " + id);
        return coinService.getACoin(id);
    }

    @PostMapping("/coins")
    public Coin createCoin(@RequestBody Coin coinData) {
        return coinService.addNewCoin(coinData);
    }

    @DeleteMapping("/coins/{coinId}")
    public List<Coin> deleteCoin(@PathVariable Long coinId) {
        coinService.deleteCoin(coinId);
        return coinService.getCoins();
    }

    @PutMapping("/coins/{coinId}")
    public void updateCoin(@PathVariable Long coinId, @RequestBody Coin reqBody) {
        System.out.println(coinId);
        System.out.println(reqBody);
        coinService.updateCoin(coinId, reqBody);
    }
}
