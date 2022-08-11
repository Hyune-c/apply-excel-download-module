package com.example.applyexceldownloadmodule.web;

import com.example.applyexceldownloadmodule.car.CarService;
import com.example.applyexceldownloadmodule.car.ExcelCarDto;
import com.lannstark.excel.ExcelFile;
import com.lannstark.excel.onesheet.OneSheetExcelFile;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarController {

	private final CarService carService;

	@GetMapping("/cars")
	public void findAll(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=car.xlsx");

		final List<ExcelCarDto> excelCarDtos = carService.findAllToExcel();
		final ExcelFile<ExcelCarDto> excelFile = new OneSheetExcelFile<>(excelCarDtos, ExcelCarDto.class);
		excelFile.write(response.getOutputStream());
	}
}
