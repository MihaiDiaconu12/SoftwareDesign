package com.example.ProjectBackend;


import com.example.ProjectBackend.model.Documentary;
import com.example.ProjectBackend.model.User;
import com.example.ProjectBackend.service.DocumentaryService;
import com.example.ProjectBackend.service.UserService;
import com.example.ProjectBackend.temporary.CredentialsTemp;
import com.example.ProjectBackend.temporary.UserTemporary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;
    private final DocumentaryService documentaryService;

    public UserResource(UserService userService, DocumentaryService documentaryService) {
        this.userService = userService;
        this.documentaryService = documentaryService;
    }

    @PostMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserTemporary userTemporary) {
        User user=new User(userTemporary.name,userTemporary.email,userTemporary.password,userTemporary.status);
        User user1 = userService.addUser(user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }


    /**
     * This method selects the documentaries and returns a list according to the status of the user.
     * @param credentialsTemp the credentials given as input
     * @return it returns the list of the documentaries that can be accessed by the user
     */
    @PostMapping("/login")
    public ResponseEntity<List<Documentary>> loginAndGetList(@RequestBody CredentialsTemp credentialsTemp){

        List<Documentary> list=new ArrayList<>();
        List<User> users = userService.findAllUsers();
        for (User i:users) {
            System.out.println(i.toString());
            System.out.println(credentialsTemp.name);
            System.out.println(credentialsTemp.password);
            if(i.getName().equals(credentialsTemp.name)&&i.getPassword().equals(credentialsTemp.password)){
                System.out.println("Ai ajuns aici");
                String currentStatus=i.getStatus();
                List<Documentary> docs=documentaryService.findAllDocumentaries();
                for (Documentary j: docs) {
                    if(j.getStatus().equals(currentStatus))
                    {
                        list.add(j);
                    }
                }
                break;
            }
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
