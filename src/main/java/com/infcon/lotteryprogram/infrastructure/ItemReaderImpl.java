package com.infcon.lotteryprogram.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.infcon.lotteryprogram.domain.Item;
import com.infcon.lotteryprogram.domain.ItemKind;
import com.infcon.lotteryprogram.domain.ItemReader;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ItemReaderImpl implements ItemReader {

    private final ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

}
