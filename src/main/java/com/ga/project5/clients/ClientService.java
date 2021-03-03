package com.ga.project5.clients;

import com.ga.project5.wallets.WalletRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final WalletRepository walletRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, WalletRepository walletRepository) {
        this.clientRepository = clientRepository;
        this.walletRepository = walletRepository;
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private Boolean checkPassword(String password, String hashedPassword) {
        if (BCrypt.checkpw(password, hashedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient(Long id) {
        Client foundClient = clientRepository.findClientById(id);
        System.out.println(foundClient);
        return foundClient;
    }

    public void createClient(Client newClient) {
        // Verify Email is Unique
        Optional<Client> clientEmail = clientRepository.findOptionalClientByEmail(newClient.getEmail());
        if (clientEmail.isPresent()) {
            throw new IllegalStateException("Email already taken.");
        }
        // Encrypt Password
        String password = newClient.getPassword();
        String hashedPassword = hashPassword(password);
        newClient.setPassword(hashedPassword);
        // Save to Repo
        clientRepository.save(newClient);
    }

    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
        walletRepository.deleteByClient(id);
    }

    public AuthUser getCredentials(Session newSession) {
        Client credentials = clientRepository.findClientByEmail(newSession.getEmail());
        System.out.println(credentials);
        AuthUser authUser = new AuthUser(credentials.getId() , credentials.getName(), credentials.getEmail(), checkPassword(newSession.getPassword(), credentials.getPassword()));
        return authUser;
    }
}
