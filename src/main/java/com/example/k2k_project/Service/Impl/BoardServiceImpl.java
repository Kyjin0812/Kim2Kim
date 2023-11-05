package com.example.k2k_project.Service.Impl;

import com.example.k2k_project.Data.*;
import com.example.k2k_project.Entity.*;
import com.example.k2k_project.Repository.*;
import com.example.k2k_project.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board getBoard(int id) {
        Optional<Board> board = boardRepository.findById(id);
        if (board.isPresent()) {
            return board.get();
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void changeBoard(int id, BoardDto boardDto) {
        Optional<Board> selected_board = boardRepository.findById(id);
        Board board;
        if (selected_board.isPresent()) {
            board = selected_board.get();
            board.setTitle(boardDto.getTitle());
            board.setDetail(boardDto.getDetail());
            boardRepository.save(board);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    @Override
    public void deleteBoard(int id) {
        Optional<Board> selectedBoard = boardRepository.findById(id);
        if (selectedBoard.isPresent()) {
            boardRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
