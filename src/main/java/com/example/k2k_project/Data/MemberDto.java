package com.example.k2k_project.Data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MemberDto {
    private String id;
    private String name;
    private String address;
    private String phone_num;
    private String password;
    private String regi_num;
    private String role;
}
