package com.ga.project5.coins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

    Optional<Coin> findOptionalCoinBySymbol(String symbol);

    Coin findCoinBySymbol(String symbol);

    Coin findCoinById(Long id);
}
