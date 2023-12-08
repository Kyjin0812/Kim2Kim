package com.example.k2k_project.Service.Impl;

import com.example.k2k_project.Entity.*;
import com.example.k2k_project.Repository.*;
import com.example.k2k_project.Service.BoardService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void findBoardById(long id) {
        boardRepository.findById(id).get();
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepository.deleteById(board.getId());
    }

    @Override
    public Page<Board> getBoardList(int page, Search search) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));

        BooleanBuilder builder = new BooleanBuilder();

        QBoard qboard = QBoard.board;

        if(search.getSearchCondition().equals("TITLE")) {
            builder.and(qboard.title.like("%" + search.getSearchKeyword() + "%"));
        }
        else if(search.getSearchCondition().equals("CONTENT")) {
            builder.and(qboard.detail.like("%" + search.getSearchKeyword() + "%"));
        }

        Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));

        return boardRepository.findAll(builder, pageable);
    }
}
