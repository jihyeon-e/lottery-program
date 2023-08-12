package com.infcon.lotteryprogram.domain.target;

import java.util.Optional;

public interface TargetAmountReader {

    Optional<TargetAmount> findById(Long id);
}
