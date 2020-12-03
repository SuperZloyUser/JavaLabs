package ru.xorsiphus.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ru.xorsiphus.MechanismUser;
import ru.xorsiphus.clocks.AlarmClock;
import ru.xorsiphus.clocks.Clock;
import ru.xorsiphus.clocks.Stopwatch;

@Configuration
@PropertySource("classpath:someProperties.properties")
@ComponentScan("ru.xorsiphus")
public class MechanismConfig
{
    @Value("${savedTime}")
    private int savedTime;

    @Bean(value = "clock")
    public Clock clock()
    {
        return new Clock("Wrist Watch", 48020);
    }

    @Bean(value = "alarmClock")
    public AlarmClock alarmClock()
    {
        return new AlarmClock("AlarmClock", 10000, 62789);
    }

    @Bean(value = "stopwatch")
    public Stopwatch stopwatch()
    {
        return new Stopwatch("Stopwatch", savedTime);
    }

    @Bean(value = "user1")
    public MechanismUser user1() { return new MechanismUser("User1", alarmClock()); }

    @Bean(value = "user2")
    public MechanismUser user2() { return new MechanismUser("User2", clock()); }

    @Bean(value = "user3", initMethod = "turnOn", destroyMethod = "turnOff")
    public MechanismUser user3() { return new MechanismUser("User3", stopwatch()); }

}
