package com.infcon.lotteryprogram.infrastructure.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infcon.lotteryprogram.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAll();
}
