package com.example.k2k_project.Service.Impl;

import com.example.k2k_project.Data.LodgmentDto;
import com.example.k2k_project.Entity.Lodgment;
import com.example.k2k_project.Repository.LodgmentRepository;
import com.example.k2k_project.Service.LodgmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class LodgmentServiceImpl implements LodgmentService {
    private final LodgmentRepository lodgmentRepository;

    @Autowired
    public LodgmentServiceImpl(LodgmentRepository lodgmentRepository) {
        this.lodgmentRepository = lodgmentRepository;
    }

    @Override
    public Lodgment getLodgment(int id) {
        Optional<Lodgment> lodgment= lodgmentRepository.findById(id);
        if (lodgment.isPresent()) {
            return lodgment.get();
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void saveLodgment(Lodgment lodgment) {
        lodgmentRepository.save(lodgment);
    }

    @Override
    public void changeLodgment(int id, LodgmentDto LodgmentDto) {
        Optional<Lodgment> selected_lodgment = lodgmentRepository.findById(id);
        Lodgment lodgment;
        if (selected_lodgment.isPresent()) {
            lodgment = selected_lodgment.get();
            lodgment.setName(LodgmentDto.getName());
            lodgment.setPhone_num(LodgmentDto.getPhone_num());
            lodgment.setType(LodgmentDto.getType());
            lodgment.setRegion_do(LodgmentDto.getRegion_do());
            lodgment.setRegion_district(LodgmentDto.getRegion_district());
            lodgment.setRoom_num(LodgmentDto.getRoom_num());
            lodgmentRepository.save(lodgment);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Lodgment> findLodgments() {
        return lodgmentRepository.findAll();
    }

    @Override
    public void deleteLodgment(int id) {
        Optional<Lodgment> selectedLodgment = lodgmentRepository.findById(id);
        if (selectedLodgment.isPresent()) {
            lodgmentRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
