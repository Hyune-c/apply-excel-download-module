package com.example.applyexceldownloadmodule.config;

import com.example.applyexceldownloadmodule.car.Car;
import com.example.applyexceldownloadmodule.car.CarRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InitData {

	private final CarRepository carRepository;

	@PostConstruct
	public void postConstruct() {
		createCar();
	}

	private void createCar() {
		carRepository.saveAll(
				List.of(
						Car.builder().company("현대").name("소나타").price(100).rating(4.90).build(),
						Car.builder().company("르노삼성").name("QM6").price(200).rating(4.60).build(),
						Car.builder().company("기아").name("K7").price(300).rating(4.30).build()
				));
	}
}
