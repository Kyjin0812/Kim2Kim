package com.example.k2k_project.Data;

import com.example.k2k_project.Entity.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GradeDto {
    private List<Member> member_id;
    private List<Lodgment> lodgment_id;
    private float grade;
    private String detail;
}
