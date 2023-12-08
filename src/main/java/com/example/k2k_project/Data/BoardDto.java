package com.example.k2k_project.Data;

import com.example.k2k_project.Entity.Member;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardDto {
    private String title;
    private String detail;
    private long like;
    private long dislike;
    private Date start_date;
    private Date update_date;
    private List<Member> member_id;
}
