package com.infcon.lotteryprogram.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ItemKindConverter implements AttributeConverter<ItemKind, String> {

    @Override
    public String convertToDatabaseColumn(final ItemKind attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getValue();
    }

    @Override
    public ItemKind convertToEntityAttribute(final String dbData) {
        return ItemKind.from(dbData);
    }
}
