package com.example.demo.repository;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.Facility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByFacilityAndDate(Facility facility, LocalDate date);

    boolean existsByFacilityAndDateAndStartTimeLessThanAndEndTimeGreaterThan(
            Facility facility, LocalDate date, LocalTime endTime, LocalTime startTime
    );
}
