package com.infcon.lotteryprogram.infrastructure.target;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infcon.lotteryprogram.domain.target.TargetAmount;

public interface TargetAmountRepository extends JpaRepository<TargetAmount, Long> {
}
