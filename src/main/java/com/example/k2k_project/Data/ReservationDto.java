package com.example.k2k_project.Data;

import com.example.k2k_project.Entity.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReservationDto {
    private List<User> user_id;
    private List<Lodgment> lodgment_id;
    private int people_num;
    private int period;
}
