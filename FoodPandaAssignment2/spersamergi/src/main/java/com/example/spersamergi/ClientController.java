package com.example.spersamergi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping("/api2")
public class ClientController {

    @Autowired
    ClientService clientService;
    @PostMapping("/set-up")
    public ResponseEntity<?> registerClient(@RequestBody setUpDTO setUpDTO) throws ClassNotFoundException, SQLException {

        Client newClient = new Client(setUpDTO.username,setUpDTO.password,setUpDTO.email);
        List<Client> clients=clientService.getAllClients();
        boolean found=false;
        for (Client i: clients) {
            if(i.getName().equals(newClient.getName())||i.getEmail().equals(newClient.getEmail())){
                found=true;
                break;
            }
        }

        if(found){
            return new ResponseEntity<String>("This is it",HttpStatus.OK);
        }
        clientService.addClient(newClient);
        return new ResponseEntity<Client>(newClient,HttpStatus.CREATED);
        //return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/checkcredentials")
    public ResponseEntity<?> checkCredentials(@RequestBody Credentials credentials){
        List<Client> clients=clientService.getAllClients();
        boolean found=false;
        for (Client i: clients) {
            if(i.getName().equals(credentials.username)&&i.getPassword().equals(credentials.password)){

                found=true;
                return new ResponseEntity<Client>(i,HttpStatus.CREATED);
                //break;
            }
        }

        //if(found){
          //  return new ResponseEntity<Credentials>(credentials,HttpStatus.CREATED);
        //}

        return new ResponseEntity<String>("This is it",HttpStatus.OK);
    }
}
