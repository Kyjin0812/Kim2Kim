package com.example.k2k_project.Repository;

import com.example.k2k_project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
