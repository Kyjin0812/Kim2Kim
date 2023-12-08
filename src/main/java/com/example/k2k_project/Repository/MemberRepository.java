package com.example.k2k_project.Repository;

import com.example.k2k_project.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}