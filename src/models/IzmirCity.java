package com.example.models;

import com.example.utils.ResourceType;

import java.awt.geom.Point2D;
import java.util.Map;

public class IzmirCity extends City {
    public IzmirCity(Point2D location) {
        super("Izmir", location, 80);
    }

    @Override
    public void produceResources() {
        Map<ResourceType, Integer> resources = getResources();
        Map<ResourceType, Integer> producedResources = getProducedResources();

        producedResources.put(ResourceType.MEAT, getRandomizedProduction(40));
        producedResources.put(ResourceType.WATER, getRandomizedProduction(35));
        producedResources.put(ResourceType.WINE, getRandomizedProduction(30));
        producedResources.put(ResourceType.APPLE, getRandomizedProduction(20));
        producedResources.put(ResourceType.PEAR, getRandomizedProduction(30));
        producedResources.put(ResourceType.STEEL, getRandomizedProduction(10));

        resources.put(ResourceType.MEAT, resources.get(ResourceType.MEAT) + producedResources.get(ResourceType.MEAT));
        resources.put(ResourceType.WATER, resources.get(ResourceType.WATER) + producedResources.get(ResourceType.WATER));
        resources.put(ResourceType.WINE, resources.get(ResourceType.WINE) + producedResources.get(ResourceType.WINE));
        resources.put(ResourceType.APPLE, resources.get(ResourceType.APPLE) + producedResources.get(ResourceType.APPLE));
        resources.put(ResourceType.PEAR, resources.get(ResourceType.PEAR) + producedResources.get(ResourceType.PEAR));
        resources.put(ResourceType.STEEL, resources.get(ResourceType.STEEL) + producedResources.get(ResourceType.STEEL));
    }

    @Override
    public void consumeResources() {
        Map<ResourceType, Integer> resources = getResources();
        Map<ResourceType, Integer> producedResources = getProducedResources();
        Map<ResourceType, Integer> consumedResources = getConsumedResources();

        double meatConsumptionRate = 0.6; // %60'lik tüketim oranı
        double waterConsumptionRate = 0.9; // %90'lik tüketim oranı
        double wineConsumptionRate = 0.7; // %70'lik tüketim oranı
        double appleConsumptionRate = 0.5; // %50'lik tüketim oranı
        double pearConsumptionRate = 0.4; // %40'lik tüketim oranı
        double steelConsumptionRate = 0.5; // %50'lik tüketim oranı

        consumedResources.put(ResourceType.MEAT, Math.min((int) Math.round(producedResources.get(ResourceType.MEAT) * meatConsumptionRate), resources.get(ResourceType.MEAT)));
        consumedResources.put(ResourceType.WATER, Math.min((int) Math.round(producedResources.get(ResourceType.WATER) * waterConsumptionRate), resources.get(ResourceType.WATER)));
        consumedResources.put(ResourceType.WINE, Math.min((int) Math.round(producedResources.get(ResourceType.WINE) * wineConsumptionRate), resources.get(ResourceType.WINE)));
        consumedResources.put(ResourceType.APPLE, Math.min((int) Math.round(producedResources.get(ResourceType.APPLE) * appleConsumptionRate), resources.get(ResourceType.APPLE)));
        consumedResources.put(ResourceType.PEAR, Math.min((int) Math.round(producedResources.get(ResourceType.PEAR) * pearConsumptionRate), resources.get(ResourceType.PEAR)));
        consumedResources.put(ResourceType.STEEL, Math.min((int) Math.round(producedResources.get(ResourceType.STEEL) * steelConsumptionRate), resources.get(ResourceType.STEEL)));

        resources.put(ResourceType.MEAT, resources.get(ResourceType.MEAT) - consumedResources.get(ResourceType.MEAT));
        resources.put(ResourceType.WATER, resources.get(ResourceType.WATER) - consumedResources.get(ResourceType.WATER));
        resources.put(ResourceType.WINE, resources.get(ResourceType.WINE) - consumedResources.get(ResourceType.WINE));
        resources.put(ResourceType.APPLE, resources.get(ResourceType.APPLE) - consumedResources.get(ResourceType.APPLE));
        resources.put(ResourceType.PEAR, resources.get(ResourceType.PEAR) - consumedResources.get(ResourceType.PEAR));
        resources.put(ResourceType.STEEL, resources.get(ResourceType.STEEL) - consumedResources.get(ResourceType.STEEL));
    }
}
