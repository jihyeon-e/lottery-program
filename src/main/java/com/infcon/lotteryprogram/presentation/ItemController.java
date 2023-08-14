package com.infcon.lotteryprogram.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infcon.lotteryprogram.domain.item.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/api/winning/items")
    public ItemResponseDto getWinningItem() {
        return ItemResponseDto.of(itemService.getWinningItem());
    }
}
