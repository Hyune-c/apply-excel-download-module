package com.example.applyexceldownloadmodule.car;

import com.lannstark.ExcelColumn;
import com.lannstark.ExcelColumnStyle;
import com.lannstark.style.DefaultExcelCellStyle;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class ExcelCarDto {

	@ExcelColumn(headerName = "ROW",
			headerStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BLUE_HEADER")
	)
	private Long carId;

	@ExcelColumn(headerName = "회사",
			headerStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BLUE_HEADER")
	)
	private String company;

	@ExcelColumn(headerName = "차종",
			headerStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BLUE_HEADER")
	)
	private String name;

	@ExcelColumn(headerName = "가격",
			bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY")
	)
	private Integer price;

	@ExcelColumn(headerName = "평점",
			bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY")
	)
	private Double rating;

	public static ExcelCarDto of(final Car car) {
		return ExcelCarDto.builder()
				.carId(car.getCarId())
				.company(car.getCompany())
				.name(car.getName())
				.price(car.getPrice())
				.rating(car.getRating())
				.build();
	}
}
