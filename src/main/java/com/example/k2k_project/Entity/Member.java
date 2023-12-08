package com.example.k2k_project.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="user")
public class Member {
    @Id
    @Column(name = "user_id", length = 14)
    private String id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 60)
    private String address;

    @Column(length = 13, nullable = false)
    private String phone_num;

    @Column(nullable = false)
    private String password;

    @Column(length = 14, nullable = false)
    private String regi_num;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled;

    @OneToMany
    private List<Grade> grade = new ArrayList<Grade>();

    @OneToMany
    private List<Reservation> reservation = new ArrayList<Reservation>();

    @OneToMany
    private List<Board> board = new ArrayList<Board>();

    @OneToMany
    private List<Comment> comment = new ArrayList<Comment>();
}
