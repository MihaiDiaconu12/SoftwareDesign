package com.example.ProjectBackend.repo;

import com.example.ProjectBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
