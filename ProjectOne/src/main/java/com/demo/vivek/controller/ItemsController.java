package com.demo.vivek.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.vivek.dto.ItemDto;
import com.demo.vivek.model.Response;
import com.demo.vivek.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemsController {

	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "API to add items")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"), })
	@PostMapping("/add-items")
	public Response<Object> addItems(@Valid @RequestBody List<ItemDto> itemDto) {
		return itemService.addItems(itemDto);
	}

	@ApiOperation(value = "API to fetch items")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"), })
	@GetMapping("/fetch-items")
	public Response<Object> fetchItem(@RequestParam Long itemsId) {
		return itemService.fetchItem(itemsId);
	}
}