package com.carRepair.carRepair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {CarRepairApplication.class, Jsr310JpaConverters.class})
public class CarRepairApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRepairApplication.class, args);
	}
}
