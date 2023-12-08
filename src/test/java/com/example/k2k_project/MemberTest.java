package com.example.k2k_project;

import com.example.k2k_project.Entity.Member;
import com.example.k2k_project.Entity.Role;
import com.example.k2k_project.Repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Member 데이터 생성")
    void save() {
        // admin 계정
        // given
        Member admin = new Member();
        admin.setId("Kyjin0812");
        admin.setName("김용진");
        admin.setPhone_num("010-9734-3216");
        admin.setRegi_num("000812-0000000");
        admin.setRole(Role.ADMIN);
        admin.setPassword(passwordEncoder.encode("0812"));

        // when
        Member savedMember1 = memberRepository.save(admin);
        // then
        assertEquals(admin.getName(), savedMember1.getName());

        //member 계정
        Member member = new Member();
        member.setId("member_a");
        member.setName("Member_A");
        member.setPhone_num("010-1234-4321");
        member.setRegi_num("000000-0000000");
        member.setRole(Role.MEMBER);
        member.setPassword(passwordEncoder.encode("1234"));
        // when
        Member savedMember2 = memberRepository.save(member);
        // then
        assertEquals(member.getName(), savedMember2.getName());
    }
}
