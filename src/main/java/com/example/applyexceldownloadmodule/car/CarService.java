package com.example.applyexceldownloadmodule.car;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarService {

	private final CarRepository carRepository;

	public List<ExcelCarDto> findAllToExcel() {
		return carRepository.findAll().stream()
				.map(ExcelCarDto::of)
				.collect(Collectors.toList());
	}
}
