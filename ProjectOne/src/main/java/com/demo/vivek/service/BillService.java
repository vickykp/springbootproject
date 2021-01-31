package com.demo.vivek.service;

import com.demo.vivek.dto.BillDto;
import com.demo.vivek.model.Response;

public interface BillService {

	Response<Object> generateBills(BillDto billDto);

	Response<Object> generateBillsWithoutPreffered(BillDto billDto, Boolean preffered);

}
