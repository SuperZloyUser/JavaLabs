package com.superzloyuser.entities;

import java.util.Objects;

public class Bird extends Animal{

    private String Subspecies;
    private int SubTest;

    public Bird() {
        this.Subspecies = "Unknown";
        this.SubTest = 0;
    }

    public Bird(String Name, int Test, String subspecies, int subTest) {
        super(Name, Test);
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
        if (!(o instanceof Bird)) return false;
        if (!super.equals(o)) return false;
        Bird bird = (Bird) o;
        return SubTest == bird.SubTest &&
                this.Subspecies.equals(bird.Subspecies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Subspecies, SubTest);
    }

    @Override
    public String toString() {
        return "Bird{" +
                "Species='" + super.getSpecies() + '\'' +
                ", Test=" + super.getTest() +
                ", Subspecies='" + Subspecies + '\'' +
                ", SubTest=" + SubTest +
                '}';
    }
}
