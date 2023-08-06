package com.infcon.lotteryprogram.domain;

import java.util.List;
import java.util.Optional;

public interface ItemReader {

    List<Item> findAll();

    Optional<Item> findById(Long id);
}
