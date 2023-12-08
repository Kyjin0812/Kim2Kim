package com.example.k2k_project.Entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String detail;

    @Column
    private Long b_like = 0L;

    @Column
    private Long b_dislike = 0L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date start_date = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date update_date = new Date();

    @Column
    private Long cnt = 0L;

    @OneToMany
    private List<Comment> comment = new ArrayList<Comment>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private Member member;

    public void setMember(Member member) {
        this.member = member;
        member.getBoard().add(this);
    }
}
