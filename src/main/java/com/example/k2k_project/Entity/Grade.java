package com.example.k2k_project.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5, nullable = false)
    private Float grade;

    @Column(length = 100, nullable = false)
    private String detail;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "lodgment_id")
    private Lodgment lodgment;
}
