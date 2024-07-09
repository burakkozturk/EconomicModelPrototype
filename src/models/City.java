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
    private int population;
    private Random random = new Random();

    public City(String name, Point2D location, int population) {
        this.name = name;
        this.location = location;
        this.population = population;
        this.resources = new HashMap<>();
        this.producedResources = new HashMap<>();
        this.consumedResources = new HashMap<>();
        initializeResources();
    }

    private void initializeResources() {
        for (ResourceType resourceType : ResourceType.values()) {
            resources.put(resourceType, 0);
            producedResources.put(resourceType, 0);
            consumedResources.put(resourceType, 0);
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

    public Map<ResourceType, Integer> getResources() {
        return resources;
    }

    public Map<ResourceType, Integer> getProducedResources() {
        return producedResources;
    }

    public Map<ResourceType, Integer> getConsumedResources() {
        return consumedResources;
    }

    public abstract void produceResources();

    protected int getRandomizedProduction(int baseProduction) {
        double changeFactor = 1 + (random.nextDouble() * 0.3) - 0.15; // %15 kayıp veya kazanç
        return (int) Math.round(baseProduction * changeFactor);
    }

    public abstract void consumeResources();

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", population=" + population +
                ", resources=" + resources +
                '}';
    }
}
