package com.example.k2k_project.config;

import com.example.k2k_project.Entity.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {
    private static final long serialVersionUID = 1L;
    public SecurityUser(Member member) {
        super(member.getId(), member.getPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));
        System.out.println(member.getId());
    }
}
