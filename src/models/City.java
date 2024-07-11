package com.example.models;

import com.example.utils.ResourceType;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class City {
    private String name;
    private Point2D location;
    private Map<ResourceType, Integer> resources;
    private Map<ResourceType, Integer> producedResources;
    private Map<ResourceType, Integer> consumedResources;
    private Map<ResourceType, Double> prices;
    private int population;
    private int wealth;
    private Random random = new Random();

    public City(String name, Point2D location, int population) {
        this.name = name;
        this.location = location;
        this.population = population;
        this.wealth = population; // Başlangıçta zenginlik nüfus ile eşit
        this.resources = new HashMap<>();
        this.producedResources = new HashMap<>();
        this.consumedResources = new HashMap<>();
        this.prices = new HashMap<>();
        initializeResources();
        initializePrices();
    }

    private void initializeResources() {
        for (ResourceType resourceType : ResourceType.values()) {
            resources.put(resourceType, 0);
            producedResources.put(resourceType, 0);
            consumedResources.put(resourceType, 0);
        }
    }

    private void initializePrices() {
        for (ResourceType resourceType : ResourceType.values()) {
            prices.put(resourceType, 10.0); // Başlangıç fiyatı
        }
    }

    public String getName() {
        return name;
    }

    public Point2D getLocation() {
        return location;
    }

    public int getPopulation() {
        return population;
    }

    public int getWealth() {
        return wealth;
    }

    public Map<ResourceType, Integer> getResources() {
        return resources;
    }

    public Map<ResourceType, Integer> getProducedResources() {
        return producedResources;
    }

    public Map<ResourceType, Integer> getConsumedResources() {
        return consumedResources;
    }

    public Map<ResourceType, Double> getPrices() {
        return prices;
    }

    public abstract void produceResources();

    protected int getRandomizedProduction(int baseProduction) {
        double changeFactor = 1 + (random.nextDouble() * 0.3) - 0.15; // %15 kayıp veya kazanç
        return (int) Math.round(baseProduction * changeFactor);
    }

    public abstract void consumeResources();

    public void updatePrices() {
        for (ResourceType resourceType : ResourceType.values()) {
            double supply = resources.get(resourceType);
            double demand = consumedResources.get(resourceType);
            double price = prices.get(resourceType);

            if (supply > demand) {
                price *= 0.9; // Arz fazlaysa fiyatı düşür
            } else if (supply < demand) {
                price *= 1.1; // Talep fazlaysa fiyatı arttır
            }

            prices.put(resourceType, Math.max(price, 1.0)); // Fiyatın en az 1 olmasını sağla
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", population=" + population +
                ", wealth=" + wealth +
                ", resources=" + resources +
                ", prices=" + prices +
                '}';
    }
}
