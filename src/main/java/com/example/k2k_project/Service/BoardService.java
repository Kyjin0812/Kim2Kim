package com.example.k2k_project.Service;

import com.example.k2k_project.Data.BoardDto;
import com.example.k2k_project.Entity.Board;

import java.util.List;

public interface BoardService {
    Board getBoard(int id);
    void saveBoard(Board board);
    void changeBoard(int id, BoardDto BoardDto);
    List<Board> findBoards();
    void deleteBoard(int id);
}
