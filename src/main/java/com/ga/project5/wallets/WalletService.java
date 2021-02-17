package com.ga.project5.wallets;

import com.ga.project5.clients.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getWallet(Long id) {
        List<Wallet> allWallets = walletRepository.findAllByClient(id);
        System.out.println("All Wallets: " + allWallets);
        return allWallets;
    }

    public void createWalletEntry(Wallet newWallet) {
        Optional<Wallet> foundWallet;
        foundWallet = walletRepository.findByClientAndCoinId(newWallet.getClient(), newWallet.getCoinId());
        if (!foundWallet.isPresent()) {
            walletRepository.save(newWallet);
        }
    }

    public void deleteWalletEntry(Long id) {
        Wallet toDelete = walletRepository.findByCoinId(id);
        System.out.println(toDelete);
        walletRepository.delete(toDelete);
    }
}
