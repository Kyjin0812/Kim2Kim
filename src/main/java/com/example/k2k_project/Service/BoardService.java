package com.example.k2k_project.Service;

import com.example.k2k_project.Data.BoardDto;
import com.example.k2k_project.Entity.Board;
import com.example.k2k_project.Entity.Search;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BoardService {
    void saveBoard(Board board);
    void findBoardById(long id);
    void deleteBoard(Board board);
    Page<Board> getBoardList(int page, Search search);
}
