package com.example.ProjectBackend.repo;

import com.example.ProjectBackend.model.Documentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentaryRepo extends JpaRepository<Documentary, Long> {

}
