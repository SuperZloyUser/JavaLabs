package ru.xorsiphus.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.xorsiphus.WebApp;

@Component
public class ActiveMQListener
{
    private static final Logger log = LoggerFactory.getLogger(WebApp.class);

    @JmsListener(destination = "Add Notification")
    public void addListener(String message)
    {
        log.info("Add notification: \"" + message + "\"");
    }

    @JmsListener(destination = "Edit Notification")
    public void editListener(String message)
    {
        log.info("Edit notification: \"" + message + "\"");
    }

    @JmsListener(destination = "Delete Notification")
    public void deleteListener(String message)
    {
        log.info("Delete notification: \"" + message + "\"");
    }
}
