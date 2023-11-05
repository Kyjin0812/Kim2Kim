package com.example.k2k_project.Service;

import com.example.k2k_project.Data.ReservationDto;
import com.example.k2k_project.Entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation getReservation(int id);
    void saveReservation(Reservation reservation);
    void changeReservation(int id, ReservationDto ReservationDto);
    List<Reservation> findReservations();
    void deleteReservation(int id);
}
