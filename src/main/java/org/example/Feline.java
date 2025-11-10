package org.example;

import java.util.List;

public class Feline extends Animal {

    @Override
    public List<String> eatMeat() {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}