package com.demo.vivek.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.vivek.dao.ItemsDao;
import com.demo.vivek.dto.ItemDto;
import com.demo.vivek.model.Items;
import com.demo.vivek.model.Response;
import com.demo.vivek.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsDao itemsDao;

	@Override
	public Response<Object> addItems(@Valid List<ItemDto> itemDto) {
		if (itemDto != null) {
			itemDto.parallelStream().forEachOrdered(item -> {
				Items itemDbObj = new Items();
				itemDbObj.setName(item.getName());
				itemDbObj.setDiscount(item.getDiscount());
				itemDbObj.setPrice(item.getPrice());
				itemsDao.save(itemDbObj);
			});
		}
		return new Response<>(200, "Item Added Successfully.");
	}

	@Override
	public Response<Object> fetchItem(Long itemsId) {
		Optional<Items> itemData = itemsDao.findByItemsId(itemsId);
		if (itemData.isPresent()) {
			return new Response<>(200, "Item Fetched Successfully.", itemData);
		} else {
			return new Response<>(205, "No Data Found");
		}
	}

}
