package com.ga.project5.clients;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
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

    public void createClient(Client newClient) {
        String password = newClient.getPassword();
        String hashedPassword = hashPassword(password);
        newClient.setPassword(hashedPassword);
        clientRepository.save(newClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Boolean getCredentials(Session newSession) {
        Client credentials = clientRepository.findClientByEmail(newSession.getEmail());
        System.out.println(credentials.getPassword());
        return checkPassword(newSession.getPassword(), credentials.getPassword());
    }
}
