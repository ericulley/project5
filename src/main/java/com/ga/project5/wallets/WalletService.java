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
        foundWallet = walletRepository.findByClientAndCoinSymbol(newWallet.getClient(), newWallet.getCoinSymbol());
        if (!foundWallet.isPresent()) {
            walletRepository.save(newWallet);
        } else {
            throw new IllegalStateException("This coin is already in this user's wallet.");
        }
    }

    public void updateWalletEntry(Long id, Wallet newAmount) {
        Wallet foundWallet = walletRepository.findWalletById(id);
        foundWallet.setAmountOwned(newAmount.getAmountOwned());
        walletRepository.save(foundWallet);
    }

    public void deleteWalletEntry(Long id) {
        walletRepository.deleteById(id);
    }

}
