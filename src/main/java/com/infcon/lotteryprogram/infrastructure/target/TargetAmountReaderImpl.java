package com.infcon.lotteryprogram.infrastructure.target;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.infcon.lotteryprogram.domain.target.TargetAmount;
import com.infcon.lotteryprogram.domain.target.TargetAmountReader;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class TargetAmountReaderImpl implements TargetAmountReader {

    private final TargetAmountRepository targetAmountRepository;

    @Override
    public Optional<TargetAmount> findById(Long id) {
        return targetAmountRepository.findById(id);
    }
}
