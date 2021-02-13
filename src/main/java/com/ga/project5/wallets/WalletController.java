package com.ga.project5.wallets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallet")
    public void createWalletEntry(@RequestBody Wallet newWallet) {
        walletService.createWalletEntry(newWallet);
    }

    @DeleteMapping("/wallet/{id}")
    public void deleteWalletEntry(@PathVariable Long id) {
        walletService.deleteWalletEntry(id);
    }

}
