package com.example.k2k_project.Service;

import com.example.k2k_project.Entity.Member;
import com.example.k2k_project.Repository.MemberRepository;
import com.example.k2k_project.config.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    private MemberRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optional = userRepository.findById(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException(username + " 사용자 없음");
        } else {
            Member member = optional.get();
            System.out.println(member.getRole());
            return new SecurityUser(member);
        }
    }
}
