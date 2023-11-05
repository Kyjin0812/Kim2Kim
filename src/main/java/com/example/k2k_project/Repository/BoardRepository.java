package com.example.k2k_project.Repository;

import com.example.k2k_project.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
