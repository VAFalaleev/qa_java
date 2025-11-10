package org.example;

import java.util.List;

public abstract class Animal {

    public abstract List<String> eatMeat() throws Exception;

    public abstract String getFamily();

    protected List<String> getFood(String animalType) {
        // Логика получения пищи в зависимости от типа животного
        if ("Хищник".equals(animalType)) {
            return List.of("Животные", "Птицы", "Рыба");
        } else if ("Травоядное".equals(animalType)) {
            return List.of("Трава", "Различные растения");
        } else {
            return List.of();
        }
    }
}