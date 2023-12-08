package com.example.k2k_project.Service;

import com.example.k2k_project.Data.ReservationDto;
import com.example.k2k_project.Entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation getReservation(long id);
    void saveReservation(Reservation reservation);
    void changeReservation(long id, ReservationDto ReservationDto);
    List<Reservation> findReservations();
    void deleteReservation(long id);
}
