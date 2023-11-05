package com.example.k2k_project.Service.Impl;

import com.example.k2k_project.Data.ReservationDto;
import com.example.k2k_project.Entity.Reservation;
import com.example.k2k_project.Repository.ReservationRepository;
import com.example.k2k_project.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation getReservation(int id) {
        Optional<Reservation> reservation= reservationRepository.findById(id);
        if (reservation.isPresent()) {
            return reservation.get();
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void changeReservation(int id, ReservationDto ReservationDto) {
        Optional<Reservation> selected_reservation = reservationRepository.findById(id);
        Reservation reservation;
        if (selected_reservation.isPresent()) {
            reservation = selected_reservation.get();
            reservation.setPeople_num(ReservationDto.getPeople_num());
            reservation.setPeriod(ReservationDto.getPeriod());
            reservationRepository.save(reservation);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Reservation> findReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(int id) {
        Optional<Reservation> selectedReservation = reservationRepository.findById(id);
        if (selectedReservation.isPresent()) {
            reservationRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
