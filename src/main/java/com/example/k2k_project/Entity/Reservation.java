package com.example.k2k_project.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 3, nullable = false)
    private long people_num;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date start_date = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date last_date = new Date();

    @Column(length = 3, nullable = false)
    private long period;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "lodgment_id")
    private Lodgment lodgment;
}
