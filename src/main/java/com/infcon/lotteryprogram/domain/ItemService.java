package com.infcon.lotteryprogram.domain;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemReader itemReader;

    @Transactional
    public String getWinningItem() {
        List<Item> items = itemReader.findAll();

        ItemKind winningItem = getWinningItem(items, getTotalAmount(items));

        subtractItem(items, winningItem);

        return winningItem.getValue();
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
