package com.ga.project5.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping("/clients")
    public List<Client> createClient(@RequestBody Client newClient) {
        clientService.createClient(newClient);
        return clientService.getClients();
    }

    @DeleteMapping("/clients/{id}")
    public List<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return clientService.getClients();
    }

    @PostMapping("/sessions")
    public Boolean startSession(@RequestBody Session newSession) {
        return clientService.getCredentials(newSession);
    }
}