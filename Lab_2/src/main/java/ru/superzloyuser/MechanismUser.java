package ru.superzloyuser;

import ru.superzloyuser.Clocks.Mechanism;

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

    @Override
    public String toString()
    {
        return "Person: " + name + "; Clock - " + mechanism.getInfo() +
                "; " + mechanism.getTime();
    }
}
