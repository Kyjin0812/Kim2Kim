package com.example.k2k_project.Entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String detail;

    @Column
    private Long c_like = 0L;

    @Column
    private Long c_dislike = 0L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date start_date = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date update_date = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
