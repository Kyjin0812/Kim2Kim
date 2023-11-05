package com.example.k2k_project.Data;

import com.example.k2k_project.Entity.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardDto {
    private List<User> user_id;
    private String title;
    private String detail;
    private int like;
    private int dislike;
}
