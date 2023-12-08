package com.example.k2k_project.Service.Impl;

import com.example.k2k_project.Entity.Grade;
import com.example.k2k_project.Repository.GradeRepository;
import com.example.k2k_project.Service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade getGrade(long id) {
        Optional<Grade> grade = gradeRepository.findById(id);
        if (grade.isPresent()) {
            return grade.get();
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void saveGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public List<Grade> findGrades() {
        return gradeRepository.findAll();
    }

}
