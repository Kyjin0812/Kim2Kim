package com.example.k2k_project.Service;

import com.example.k2k_project.Entity.Grade;

import java.util.List;

public interface GradeService {
    Grade getGrade(int id);
    void saveGrade(Grade grade);
    //void changeGrade(int id, GradeDto GradeDto);
    List<Grade> findGrades();
}
