package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Facility facility;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    // Getters and setters
}
