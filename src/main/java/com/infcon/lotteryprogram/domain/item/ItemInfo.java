package com.infcon.lotteryprogram.domain.item;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ItemInfo {

    private Boolean isLast;
    private String item;

    public static ItemInfo of(boolean isLast, String item) {
        return new ItemInfo(isLast, item);
    }
}
