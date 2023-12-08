package com.example.k2k_project.Data;

import com.example.k2k_project.Entity.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReservationDto {
    private long people_num;
    private long period;
    private Date start_date;
    private Date last_date;
    private List<Member> member_id;
    private List<Lodgment> lodgment_id;
}
