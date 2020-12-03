package ru.xorsiphus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.xorsiphus.clocks.Mechanism;

@Component("UserComponent")
public class MechanismUser {
    private String name = "DefaultUser";
    private final Mechanism mechanism;

    @Autowired
    public MechanismUser(@Qualifier("clock") Mechanism mechanism)
    {
        this.mechanism = mechanism;
    }

    @Bean("UserByFabric")
    public static MechanismUser UserByFabric(@Qualifier("clock") Mechanism mechanism)
    {
        return new MechanismUser("New one", mechanism);
    }

    public MechanismUser(String name, @Qualifier("clock") Mechanism mechanism)
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
        System.out.println("[LOG]: Created: " + name);
    }

    public void turnOff()
    {
        System.out.println("[LOG]: Destroyed" + name);
    }

    @Override
    public String toString()
    {
        return "Person: " + name + "; Clock - " + mechanism.getInfo() +
                "; " + mechanism.getTime();
    }
}
