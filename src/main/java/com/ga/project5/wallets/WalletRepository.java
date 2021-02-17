package com.ga.project5.wallets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByClientAndCoinId(Long client, Long coinId);

    List<Wallet> findAllByClient(Long client);

    void deleteByCoinId(Long id);

    Wallet findByCoinId(Long id);
}
