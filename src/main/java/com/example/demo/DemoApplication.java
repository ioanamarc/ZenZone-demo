package com.example.demo;

import com.example.demo.entity.Facility;
import com.example.demo.repository.FacilityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadFacilities(FacilityRepository facilityRepository) {
		return args -> {
			String[] facilityNames = {
					"Pingpong Table",
					"Fussball Board 1",
					"Fussball Board 2",
					"Boardgames Room",
					"Playstation",
					"Massage Chair"
			};

			for (String name : facilityNames) {
				if (facilityRepository.findByName(name).isEmpty()) {
					Facility facility = new Facility();
					facility.setName(name);
					facilityRepository.save(facility);
					System.out.println("Inserted: " + name);
				} else {
					System.out.println("Already exists: " + name);
				}
			}
		};
	}


}
