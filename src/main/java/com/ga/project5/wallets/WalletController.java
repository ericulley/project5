package com.ga.project5.wallets;

import com.ga.project5.clients.AuthUser;
import com.ga.project5.clients.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/wallets/{id}")
    public List<Wallet> getWallet(@PathVariable Long id) {
        return walletService.getWallet(id);
    }

    @PostMapping("/wallets")
    public void createWalletEntry(@RequestBody Wallet newWallet) {
        System.out.println(newWallet);
        walletService.createWalletEntry(newWallet);
    }

    @DeleteMapping("/wallets/{id}")
    public void deleteWalletEntry(@PathVariable Long id) {
        walletService.deleteWalletEntry(id);
    }

}
