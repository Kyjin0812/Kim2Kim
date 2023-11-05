package com.example.k2k_project.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="user")
public class User {
    @Id
    @Column(name = "user_id", length = 14)
    private String id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 60)
    private String address;

    @Column(length = 13, nullable = false)
    private String phone_num;

    @Column(length = 20)
    private String password;

    @Column(length = 14, nullable = false)
    private String regi_num;

    @Column(length = 10, nullable = false)
    private String type;
/*
    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("id asc")
    @JoinColumn(name = "user_id")
    private List<Grade> grade = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("id asc")
    @JoinColumn(name = "user_id")
    private List<Reservation> reservation = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("id asc")
    @JoinColumn(name = "user_id")
    private List<Board> board = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("id asc")
    @JoinColumn(name = "user_id")
    private List<Comment> comment = new ArrayList<>();*/
}
