package com.demo.vivek.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.vivek.model.Items;

public interface ItemsDao extends JpaRepository<Items, Long> {

	Optional<Items> findByItemsId(Long itemsId);

	List<Items> findByItemsIdIn(List<Long> itemsIds);

}
