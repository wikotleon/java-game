package com.game;

import com.game.enums.AttributeType;
import java.util.EnumMap;

public class Character {
    private final String name;
    private final EnumMap<AttributeType, Integer> attributes;

    public Character(String name, int[] attributeValues) {
        this.name = name;
        this.attributes = new EnumMap<>(AttributeType.class);

        AttributeType[] types = AttributeType.values();
        for (int i = 0; i < types.length; i++) {
            this.attributes.put(types[i], attributeValues[i]);
        }
    }

    public String getName() {
        return name;
    }

    public int getAttributeValue(AttributeType type) {
        return attributes.getOrDefault(type, 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + ", Attributes:");
        for (AttributeType type : AttributeType.values()) {
            sb.append(" ").append(type.name().toLowerCase()).append(": ").append(attributes.get(type));
        }
        return sb.toString();
    }
}