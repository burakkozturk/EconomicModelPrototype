package com.example;

import com.example.models.AnkaraCity;
import com.example.models.City;
import com.example.models.IstanbulCity;
import com.example.models.IzmirCity;
import com.example.utils.ResourceType;

import java.awt.geom.Point2D;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        City ankara = new AnkaraCity(new Point2D.Double(0, 0));
        City izmir = new IzmirCity(new Point2D.Double(-3, -1));
        City istanbul = new IstanbulCity(new Point2D.Double(-3, 2));

        int iterations = 5; // Kaynak üretiminin kaç kez yapılacağını belirleyin

        // İlk iterasyon: başlangıç üretimi ve tüketimi
        ankara.produceResources();
        izmir.produceResources();
        istanbul.produceResources();

        ankara.consumeResources();
        izmir.consumeResources();
        istanbul.consumeResources();

        // Geriye kalan iterasyonlar
        for (int i = 1; i <= iterations; i++) {
            System.out.println("Iteration " + i);
            printCityResources(ankara);
            printCityResources(izmir);
            printCityResources(istanbul);

            System.out.println("\nProducing Resources...");
            ankara.produceResources();
            izmir.produceResources();
            istanbul.produceResources();

            System.out.println("\nConsuming Resources...");
            ankara.consumeResources();
            izmir.consumeResources();
            istanbul.consumeResources();

            System.out.println();
        }
    }

    private static void printCityResources(City city) {
        System.out.println("City: " + city.getName());
        System.out.format("+-------------+------------+--------------+-----------------+\n");
        System.out.format("| Resource    | Produced   | Total        | Consumed        |\n");
        System.out.format("+-------------+------------+--------------+-----------------+\n");

        Map<ResourceType, Integer> resources = city.getResources();
        Map<ResourceType, Integer> producedResources = city.getProducedResources();
        Map<ResourceType, Integer> consumedResources = city.getConsumedResources();

        for (ResourceType resourceType : ResourceType.values()) {
            System.out.format("| %-11s | %-10d | %-12d | %-15d |\n",
                    resourceType,
                    producedResources.get(resourceType),
                    resources.get(resourceType),
                    consumedResources.get(resourceType));
        }

        System.out.format("+-------------+------------+--------------+-----------------+\n");
    }
}
