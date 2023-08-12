package com.infcon.lotteryprogram.infrastructure.item;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infcon.lotteryprogram.domain.item.Item;
import com.infcon.lotteryprogram.domain.item.ItemReader;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ItemReaderImpl implements ItemReader {

    private final ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

}
