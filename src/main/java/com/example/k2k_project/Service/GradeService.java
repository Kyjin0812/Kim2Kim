package com.example.k2k_project.Service;

import com.example.k2k_project.Entity.Grade;

import java.util.List;

public interface GradeService {
    Grade getGrade(long id);
    void saveGrade(Grade grade);
    //void changeGrade(long id, GradeDto GradeDto);
    List<Grade> findGrades();
}
