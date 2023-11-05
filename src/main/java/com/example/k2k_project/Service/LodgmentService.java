package com.example.k2k_project.Service;

import com.example.k2k_project.Data.LodgmentDto;
import com.example.k2k_project.Entity.Lodgment;

import java.util.List;

public interface LodgmentService {
    Lodgment getLodgment(int id);
    void saveLodgment(Lodgment lodgment);
    void changeLodgment(int id, LodgmentDto LodgmentDto);
    List<Lodgment> findLodgments();
    void deleteLodgment(int id);
}
