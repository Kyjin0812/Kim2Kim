package com.example.k2k_project.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="lodgment")
public class Lodgment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lodgment_id")
    private int id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 13, nullable = false)
    private String phone_num;

    @Column(length = 10, nullable = false)
    private String type;

    @Column(length = 10, nullable = false)
    private String region_do;

    @Column(length = 10, nullable = false)
    private String region_district;

    @Column(nullable = false)
    private Long room_num;

    @OneToMany
    private List<Grade> grade = new ArrayList<Grade>();

    @OneToMany
    private List<Reservation> reservation = new ArrayList<Reservation>();
}
