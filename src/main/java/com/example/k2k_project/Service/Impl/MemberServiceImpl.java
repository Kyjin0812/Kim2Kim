package com.example.k2k_project.Service.Impl;

import com.example.k2k_project.Data.*;
import com.example.k2k_project.Entity.*;
import com.example.k2k_project.Repository.MemberRepository;
import com.example.k2k_project.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository userRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Member getUser(String id) {
        Optional<Member> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void saveUser(Member member) {
        userRepository.save(member);
    }

    @Override
    public void changeUser(String id, MemberDto memberDto) {
        Optional<Member> selected_user = userRepository.findById(id);
        Member member;
        if (selected_user.isPresent()) {
            member = selected_user.get();
            member.setName(memberDto.getName());
            member.setAddress(memberDto.getAddress());
            member.setPhone_num(memberDto.getPhone_num());
            member.setPassword(memberDto.getPassword());
            userRepository.save(member);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Member> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        Optional<Member> selectedUser = userRepository.findById(id);
        if (selectedUser.isPresent()) {
            userRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
