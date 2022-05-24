package com.example.spersamergi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.logging.Level;
@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping("/api2")
public class ClientController {

    @Autowired
    ClientService clientService;

    Log myLog = new Log("log.txt");


    public ClientController() throws IOException {
    }

    /**
     * This is the method that will register the client in the database, using the service in the same package
     * it will search whether the client already exists in the database or not. If yes, it will be added and the
     * client will be returned. Otherwise, a string will be returned and the client forsaken
     * @param setUpDTO is the structure in which the strings given from the frontend enter and from there,
     *                 the new client can be created.
     * @return  A client if successful, a string if not.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @PostMapping("/set-up")
    public ResponseEntity<?> registerClient(@RequestBody setUpDTO setUpDTO) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Client newClient = new Client(setUpDTO.username,setUpDTO.password,setUpDTO.email);
        List<Client> clients=clientService.getAllClients();
        boolean found=false;
        for (Client i: clients) {
            if(i.getName().equals(newClient.getName())||i.getEmail().equals(newClient.getEmail())){
                found=true;
                myLog.logger.warning("This client is already here");
                break;
            }
        }

        if(found){
            return new ResponseEntity<String>("This is it",HttpStatus.OK);
        }
        PDFGeneratorService pdfGeneratorService = new PDFGeneratorService();
        pdfGeneratorService.export(newClient.toString());
        clientService.addClient(newClient);
        myLog.logger.info(newClient.toString());
        return new ResponseEntity<Client>(newClient,HttpStatus.CREATED);
        //return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


    /**
     * This method checks whether the credentials of the user are valid or not. The name and password will be searched
     * for in the database and if they match, then the user is allowed in
     * @param credentials A structure that contains two strings: one for the input username and one for the input
     *                    password.
     * @return A client, should the credentials be correct, a string should they not be in order.
     */
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
