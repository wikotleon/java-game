package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Character {
    private String name;
    private int magic;
    private int strength;
    private int endurance;
    private int charisma;
    private int perception;
    private int intelligence;

    public Character(String name, int magic, int strength, int endurance, int charisma, int perception, int intelligence) {
        this.name = name;
        this.magic = magic;
        this.strength = strength;
        this.endurance = endurance;
        this.charisma = charisma;
        this.perception = perception;
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public int getMagic() {
        return magic;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getPerception() {
        return perception;
    }

    public int getIntelligence() {
        return intelligence;
    }
}

