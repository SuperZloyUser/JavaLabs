package ru.xorsiphus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;


@SpringBootApplication
public class WebApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(WebApp.class, args);
    }
}
