package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;  // e.g. "pingpong table", "fussball board1"

    @OneToMany(mappedBy = "facility", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // Getters and setters
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
}
