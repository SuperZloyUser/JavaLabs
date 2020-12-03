package ru.superzloyuser.Clocks;

import java.util.Date;

public class AlarmClock implements Mechanism
{
    private final String name;
    private final int alarmCounter;
    private final int seconds;

    public AlarmClock(String name, int seconds, int alarmCounter)
    {
        this.name = name;
        this.seconds = seconds;
        this.alarmCounter = alarmCounter;
    }

    public String getName()
    {
        return name;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public int getAlarmCounter()
    {
        return alarmCounter;
    }

    @Override
    public String getTime() {
        return "Time: " + new Date() + "; Alarm setted at " +
                alarmCounter / 3600 + ":" + alarmCounter % 3600 / 60 +
                ":" + alarmCounter % 60;
    }

    @Override
    public String getInfo() {
        return "Alarm Clock;";
    }

    @Override
    public String toString() {
        return "AlarmClock{" +
                "name='" + name + '\'' +
                ", alarmCounter=" + alarmCounter +
                ", seconds=" + seconds +
                '}';
    }
}
