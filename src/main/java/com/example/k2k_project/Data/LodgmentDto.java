package com.example.k2k_project.Data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LodgmentDto {
    private String name;
    private String phone_num;
    private String type;
    private String region_do;
    private String region_district;
    private long room_num;
}
