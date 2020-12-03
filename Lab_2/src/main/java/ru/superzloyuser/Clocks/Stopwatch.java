package ru.superzloyuser.Clocks;

import java.util.Date;

public class Stopwatch implements Mechanism
{
    private final String name;
    private final int seconds;
    private final int startValue;

    public Stopwatch(String name, int seconds)
    {
        this.name = name;
        this.seconds = seconds;
        this.startValue = 0;
    }

    public String getName()
    {
        return name;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public int getStartValue()
    {
        return startValue;
    }

    @Override
    public String getTime() {
        return String.format("Seconds right now: %s%n", new Date().getTime() / 1000 % 60);
    }

    @Override
    public String getInfo() {
        return "Stopwatch";
    }

    @Override
    public String toString() {
        return "Stopwatch{" +
                "name='" + name + '\'' +
                ", seconds=" + seconds +
                ", startValue=" + startValue +
                '}';
    }
}
