package com.ga.project5.wallets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findAllByClient(Long client);

    Optional<Wallet> findByClientAndCoinSymbol(Long client, String coinSymbol);

    Wallet findWalletById(Long id);

    void deleteByClient(Long id);
}
