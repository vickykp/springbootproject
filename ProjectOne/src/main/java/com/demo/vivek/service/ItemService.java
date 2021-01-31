package com.demo.vivek.service;

import java.util.List;

import javax.validation.Valid;

import com.demo.vivek.dto.ItemDto;
import com.demo.vivek.model.Response;

public interface ItemService {

	Response<Object> addItems(@Valid List<ItemDto> itemDto);

	Response<Object> fetchItem(Long itemsId);

}
