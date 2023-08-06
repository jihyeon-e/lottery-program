package com.infcon.lotteryprogram.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infcon.lotteryprogram.domain.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/api/winning/items")
    public String getWinningItem() {
        return itemService.getWinningItem();
    }

    @PatchMapping("/api/winning/items/add/amount")
    public void addAirPodPro() {
        itemService.addAirPodPro();
    }
}
