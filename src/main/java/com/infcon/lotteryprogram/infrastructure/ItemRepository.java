package com.infcon.lotteryprogram.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infcon.lotteryprogram.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAll();
}
