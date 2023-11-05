package com.example.k2k_project.Data;

import com.example.k2k_project.Entity.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CommentDto {
    private List<User> user_id;
    private List<Board> board_id;
    private String detail;
    private int like;
    private int dislike;
}
