package com.superzloyuser.entities;

import java.util.Objects;

public class Animal {

    private String Species;
    private int Test;

    public Animal(){
        this.Species = "Unknown";
        this.Test = 0;
    }

    public Animal(String species, int test){
        this.Species = species;
        this.Test = test;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public int getTest() {
        return Test;
    }

    public void setTest(int test) {
        Test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Test == animal.Test &&
                Species.equals(animal.Species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Species, Test);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "Species='" + Species + '\'' +
                ", Test=" + Test +
                '}';
    }
}
