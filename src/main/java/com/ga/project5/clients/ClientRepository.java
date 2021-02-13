package com.ga.project5.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByEmail(String email);

    Optional<Client> findOptionalClientByEmail(String email);

}
