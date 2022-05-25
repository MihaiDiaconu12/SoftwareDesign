package com.example.ProjectBackend.service;

import com.example.ProjectBackend.model.Documentary;
import com.example.ProjectBackend.repo.DocumentaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentaryService {
    private final DocumentaryRepo documentaryRepo;

    @Autowired
    public DocumentaryService(DocumentaryRepo documentaryRepo) {
        this.documentaryRepo = documentaryRepo;
    }

    public Documentary addDocumentary(Documentary documentary){
        return documentaryRepo.save(documentary);
    }

    public List<Documentary> findAllDocumentaries(){
        return documentaryRepo.findAll();
    }

}
