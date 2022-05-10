package com.example.spersamergi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;

    public Client addClient(Client client){
        return clientRepo.save(client);
    }

    public List<Client> getAllClients(){
        return (List<Client>) clientRepo.findAll();
    }
}
