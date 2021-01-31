package com.demo.vivek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.vivek.dto.BillDto;
import com.demo.vivek.model.Response;
import com.demo.vivek.service.BillService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BillController {

	@Autowired
	private BillService billService;

	@ApiOperation(value = "API to generate Bill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"), })
	@PostMapping("/generate-bill-without-preffered")
	public Response<Object> generateBills(@RequestBody BillDto billDto) {
		return billService.generateBills(billDto);
	}

	@ApiOperation(value = "API to generate Bill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"), })
	@PostMapping("/generate-bill-with-preffered")
	public Response<Object> generateBillsWithoutPreffered(@RequestBody BillDto billDto,@RequestParam Boolean preffered) {
		return billService.generateBillsWithoutPreffered(billDto,preffered);
	}
}
