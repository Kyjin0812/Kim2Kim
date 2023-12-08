package com.example.k2k_project.Service;

import com.example.k2k_project.Data.*;
import com.example.k2k_project.Entity.*;

import java.util.List;

public interface MemberService {
    Member getUser(String id);
    void saveUser(Member member);
    void changeUser(String id, MemberDto memberDto);
    List<Member> findUsers();
    void deleteUser(String id);
}
