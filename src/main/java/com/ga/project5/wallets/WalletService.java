package com.ga.project5.wallets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public void createWalletEntry(Wallet newWallet) {
        walletRepository.save(newWallet);
    }

    public void deleteWalletEntry(Long id) {
        walletRepository.deleteById(id);
    }
}
