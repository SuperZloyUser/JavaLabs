package ru.superzloyuser.Clocks;

import java.util.Date;

public class Clock implements Mechanism
{
    private final String name;
    private final int seconds;

    public Clock(String name, int seconds)
    {
        this.name = name;
        this.seconds = seconds;
    }

    public String getName()
    {
        return name;
    }

    public int getSeconds()
    {
        return seconds;
    }

    @Override
    public String getTime() {
        return "Time: " + new Date(new Date().getTime() / 86400000 * 86400000 + seconds * 1000);
    }

    @Override
    public String getInfo() {
        return "Wrist Watch";
    }

    @Override
    public String toString() {
        return "Clock{" +
                "name='" + name + '\'' +
                ", seconds=" + seconds +
                '}';
    }
}
