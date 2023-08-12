package com.infcon.lotteryprogram.domain;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infcon.lotteryprogram.domain.target.TargetAmountReader;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemReader itemReader;
    private final TargetAmountReader targetAmountReader;

    @Transactional
    public String getWinningItem() {
        List<Item> items = itemReader.findAll();

        int totalAmount = getTotalAmount(items);

        List<Item> itemsWithoutAirPods = items.stream()
            .filter(item -> item.getKind() != ItemKind.AIR_POD)
            .toList();

        ItemKind winningItem = getItemKind(itemsWithoutAirPods, totalAmount);

        subtractItem(items, winningItem);

        return winningItem.getValue();
    }

    private ItemKind getItemKind(List<Item> items, int totalAmount) {
        if (totalAmount == getTargetTotalAmount()) {
            return ItemKind.AIR_POD;
        }
        return getWinningItem(items, totalAmount);
    }

    private int getTargetTotalAmount() {
        return targetAmountReader.findById(1L)
            .orElseThrow(EntityNotFoundException::new)
            .getAmount();
    }

    private void subtractItem(List<Item> items, ItemKind winningItem) {
        items.stream()
            .filter(item -> winningItem.equals(item.getKind()))
            .forEach(Item::subtractItem);
    }

    private ItemKind getWinningItem(List<Item> items, int totalAmount) {
        double[] probabilities = new double[items.size()];
        for (int i = 0; i < items.size(); i++) {
            probabilities[i] = (double)items.get(i).getAmount() / totalAmount;
        }

        return getWinningItemKind(items, probabilities);
    }

    private ItemKind getWinningItemKind(List<Item> items, double[] probabilities) {
        Random rand = new Random();
        double randomValue = rand.nextDouble();
        double cumulativeProbability = 0.0;
        ItemKind winningItemKind = null;

        for (int i = 0; i < probabilities.length; i++) {
            cumulativeProbability += probabilities[i];
            if (randomValue <= cumulativeProbability) {
                winningItemKind = items.get(i).getKind();
                break;
            }
        }

        return winningItemKind;
    }

    private int getTotalAmount(List<Item> items) {
        int totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.getAmount();
        }

        return totalAmount;
    }
}
