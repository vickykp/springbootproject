package com.demo.vivek.serviceimpl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.vivek.dao.ItemsDao;
import com.demo.vivek.dto.BillDto;
import com.demo.vivek.model.Items;
import com.demo.vivek.model.Response;
import com.demo.vivek.service.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private ItemsDao itemsDao;

	@Override
	public Response<Object> generateBills(BillDto billDto) {
		Map<String, Object> finalResponse = new HashMap<>();
		List<Items> itemListsData = new LinkedList<>();
		Double total = 0.0;
		Double internalDiscount = 0.0;
		List<Items> itemLists = itemsDao.findByItemsIdIn(billDto.getItemsIds());
		if (!itemLists.isEmpty()) {
			for (Items items : itemLists) {
				total += items.getPrice();
				internalDiscount += items.getDiscount();
				itemListsData.add(items);
			}
			finalResponse.put("Employee name : ", billDto.getEmployee().getName());
			finalResponse.put("total : ", total);
			finalResponse.put("internalDiscount : ", internalDiscount);
			finalResponse.put("itemsList", itemListsData);
			return new Response<>(200, "Bills Generated Successfully.", finalResponse);
		} else {
			return new Response<>(205, "No Data Found.");
		}

	}

	@Override
	public Response<Object> generateBillsWithoutPreffered(BillDto billDto, Boolean preffered) {
		Map<String, Object> finalResponse = new HashMap<>();
		List<Items> itemListsData = new LinkedList<>();
		Double total = 0.0;
		Double internalDiscount = 0.0;
		List<Items> itemLists = itemsDao.findByItemsIdIn(billDto.getItemsIds());
		int count = 0;
		if (!itemLists.isEmpty()) {
			for (Items items : itemLists) {
				if (preffered == Boolean.TRUE) {
					total += items.getPrice() - items.getDiscount();
					internalDiscount += items.getDiscount();
					if (String.valueOf(items.getDiscount()).equals("0.0")) {

						finalResponse.put("Total Discount Count : ", count);
					} else {
						count++;
					}
				} else {
					items.setDiscount(0.0);
					total += items.getPrice();
					internalDiscount += items.getDiscount();
				}

				itemListsData.add(items);
			}
			finalResponse.put("Employee name : ", billDto.getEmployee().getName());
			finalResponse.put("total : ", total);
			finalResponse.put("internalDiscount : ", internalDiscount);

			finalResponse.put("itemsList", itemListsData);
			return new Response<>(200, "Bills Generated Successfully.", finalResponse);
		} else {
			return new Response<>(205, "No Data Found.");
		}

	}

}
