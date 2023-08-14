package com.infcon.lotteryprogram.presentation;

import com.infcon.lotteryprogram.domain.item.ItemInfo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ItemResponseDto {

    private Boolean isLast;
    private String item;

    public static ItemResponseDto of(ItemInfo itemInfo) {
        return new ItemResponseDto(itemInfo.getIsLast(), itemInfo.getItem());
    }
}
