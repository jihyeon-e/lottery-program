package com.infcon.lotteryprogram.domain;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemKind {

    LONG_PAD("장패드"),
    HAND_FAN("부채"),
    CUP_COASTER("컵코스터"),
    VOIDELLA("보이델라"),
    GRIP_TOK("그립톡"),
    AIR_POD("에어팟 프로2");

    private final String value;

}
