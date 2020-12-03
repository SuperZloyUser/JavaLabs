package ru.xorsiphus;

import ru.xorsiphus.clocks.Mechanism;

public class MechanismUser {
    private final String name;
    private final Mechanism mechanism;

    public MechanismUser(String name, Mechanism mechanism)
    {
        this.name = name;
        this.mechanism = mechanism;
    }

    public String getName()
    {
        return name;
    }

    public Mechanism getMechanism()
    {
        return mechanism;
    }

    public void turnOn()
    {
        System.out.println("Created: " + name);
    }

    public void turnOff()
    {
        System.out.println("Destroyed" + name);
    }

    @Override
    public String toString()
    {
        return "Person: " + name + "; Clock - " + mechanism.getInfo() +
                "; " + mechanism.getTime();
    }
}
