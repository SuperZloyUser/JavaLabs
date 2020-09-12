package com.superzloyuser.entities;

import java.util.Objects;

public class Mammal extends Animal {

    private String Subspecies;
    private int SubTest;

    public Mammal() {
        Subspecies = "Unknown";
        SubTest = 0;
    }

    public Mammal(String species, int test, String subspecies, int subTest) {
        super(species, test);
        Subspecies = subspecies;
        SubTest = subTest;
    }

    public String getSubspecies() {
        return Subspecies;
    }

    public void setSubspecies(String subspecies) {
        Subspecies = subspecies;
    }

    public int getSubTest() {
        return SubTest;
    }

    public void setSubTest(int subTest) {
        SubTest = subTest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mammal)) return false;
        if (!super.equals(o)) return false;
        Mammal mammal = (Mammal) o;
        return SubTest == mammal.SubTest &&
                Subspecies.equals(mammal.Subspecies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Subspecies, SubTest);
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "Species='" + super.getSpecies() + '\'' +
                ", Test=" + super.getTest() +
                ", Subspecies='" + Subspecies + '\'' +
                ", SubTest=" + SubTest +
                '}';
    }
}
