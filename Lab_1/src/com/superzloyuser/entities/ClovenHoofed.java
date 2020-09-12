package com.superzloyuser.entities;

import java.util.Objects;

public class ClovenHoofed extends Mammal{

    private String Name;
    private int legs;

    public ClovenHoofed() {
        this.Name = "Unknown";
        this.legs = 4;
    }

    public ClovenHoofed(String species, int test, String subspecies, int subTest, String name, int legs) {
        super(species, test, subspecies, subTest);
        this.Name = name;
        this.legs = legs;
    }

    @Override
    public String getSpecies() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClovenHoofed)) return false;
        if (!super.equals(o)) return false;
        ClovenHoofed that = (ClovenHoofed) o;
        return legs == that.legs &&
                Name.equals(that.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Name, legs);
    }

    @Override
    public String toString() {
        return "ClovenHoofed{" +
                "Species='" + super.getSpecies() + '\'' +
                ", Test=" + super.getTest() +
                ", Subspecies='" + super.getSubspecies() + '\'' +
                ", SubTest=" + super.getSubTest() +
                ", Name='" + Name + '\'' +
                ", legs=" + legs +
                '}';
    }
}
