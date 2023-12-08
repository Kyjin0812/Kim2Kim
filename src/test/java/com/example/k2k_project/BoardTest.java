package com.example.k2k_project;

import com.example.k2k_project.Entity.*;
import com.example.k2k_project.Repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class BoardTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void testInsert() {
        Member member1 = new Member();
        member1.setId("member");
        member1.setPassword(encoder.encode("m123"));
        member1.setName("둘리");
        member1.setPhone_num("010-1234-4321");
        member1.setRegi_num("000000-0000000");
        member1.setRole(Role.MEMBER);
        member1.setEnabled(true);
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setId("admin");
        member2.setPassword(encoder.encode("ad123"));
        member2.setName("도우너");
        member2.setPhone_num("010-4321-1234");
        member2.setRegi_num("010101-1010101");
        member2.setRole(Role.ADMIN);
        member2.setEnabled(true);
        memberRepository.save(member2);

        for (int i=1; i<=13; i++) {
            Board board = new Board();
            board.setMember(member1);
            board.setTitle(member1.getName() + "가 등록한 게시글 " + i);
            board.setDetail(member1.getName() + "가 등록한 게시글 " + i);
            boardRepository.save(board);
        }

        for (int i=1; i<=3; i++) {
            Board board = new Board();
            board.setMember(member2);
            board.setTitle(member2.getName() + "가 등록한 게시글 " + i);
            board.setDetail(member2.getName() + "가 등록한 게시글 " + i);
            boardRepository.save(board);
        }
    }

    @Test
    public void testGetBoard() {
        Board board = boardRepository.findById(1L).get();

        System.out.println("[ " + board.getId() + "번 게시 글 상세 정보 ]");
        System.out.println("제목\t : " + board.getTitle());
        System.out.println("작성자\t : " + board.getMember().getName());
        System.out.println("내용\t : " + board.getDetail());
        System.out.println("등록일\t : " + board.getStart_date());
        System.out.println("조회수\t : " + board.getCnt());
    }

    @Test
    public void testGetBoardList() {
        Member member = memberRepository.findById("member").get();

        System.out.println("[ " + member.getName() + "가 등록한 게시글 ]");
        for (Board board : member.getBoard()) {
            System.out.println("---> " + board.toString());
        }
    }
}
