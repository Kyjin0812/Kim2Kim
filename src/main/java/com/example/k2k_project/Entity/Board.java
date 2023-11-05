package com.example.k2k_project.Entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String detail;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int like;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int dislike;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
/*
    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("id asc")
    @JoinColumn(name = "board_id")
    private List<Comment> comment = new ArrayList<>();*/
}
