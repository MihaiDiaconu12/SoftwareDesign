package com.example.ProjectBackend;

import com.example.ProjectBackend.model.Documentary;
import com.example.ProjectBackend.service.DocumentaryService;
import com.example.ProjectBackend.temporary.DocumentaryTemporary;
import com.example.ProjectBackend.temporary.IdUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/documentary")
public class DocumentaryResource {
    private final DocumentaryService documentaryService;

    public DocumentaryResource(DocumentaryService documentaryService) {
        this.documentaryService = documentaryService;
    }

    @PostMapping("/getAllDocumentaries")
    public ResponseEntity<List<Documentary>> getAllDocumentaries(){
        List<Documentary> documentaries = documentaryService.findAllDocumentaries();
        return new ResponseEntity<>(documentaries, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Documentary> addDocumentary(@RequestBody DocumentaryTemporary dT) {
        Documentary documentary=new Documentary(dT.name, dT.url,dT.description, dT.category,dT.status);
        Documentary documentary1 = documentaryService.addDocumentary(documentary);
        return new ResponseEntity<>(documentary1,HttpStatus.CREATED);
    }

    @PostMapping("/updateDoc")
    public ResponseEntity<List<Documentary>> updateDocumentary(@RequestBody IdUpdate idUpdate) throws Exception {
        Long id=Long.parseLong(idUpdate.idDoc);
        System.out.println(id);
        /*String url="jdbc:mysql://localhost:3306/imperatorapp";
        String username="root";
        String password="Mmd08sibiu*";
        Connection conn=null;
        Statement stmt=null;
        conn= DriverManager.getConnection(url,username,password);
        stmt= (Statement) conn.createStatement();
        String sql="UPDATE documentaries SET status='universal' where id="+id;
        stmt.execute();*/
        return new ResponseEntity<>(documentaryService.findAllDocumentaries(),HttpStatus.OK);
    }
}

