package com.example.utils;


public enum ResourceType {
    MEAT, WATER, WINE, APPLE, PEAR, STEEL;

    @Override
    public String toString() {
        switch(this) {
            case MEAT: return "Meat";
            case WATER: return "Water";
            case WINE: return "Wine";
            case APPLE: return "Apple";
            case PEAR: return "Pear";
            case STEEL: return "Steel";
            default: throw new IllegalArgumentException();
        }
    }
}
