package org.example;

import java.util.List;

public class Lion {

    private final Feline feline;
    private final boolean hasMane;

    public Lion(String sex) throws Exception {
        this(sex, new Feline());
    }

    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;

        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() {
        return feline.eatMeat();
    }
}