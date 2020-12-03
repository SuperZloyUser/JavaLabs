package ru.xorsiphus;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.xorsiphus.configuration.SpringConfig;
import ru.xorsiphus.dao.BookJDBC;
import ru.xorsiphus.entity.Book;

import java.sql.Date;

public class TestSpring
{
    public static void main(String[] args)
    {
        SpringApplication.run(TestSpring.class, args);

        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SpringConfig.class);
        BookJDBC bookJdbc = context.getBean("BookJDBC", BookJDBC.class);
//        Book book = new Book("Crime and Punishment", "Dost", "Printer1337",
//                250, new Date(1337123));
        System.out.println(bookJdbc.findById(1));

        context.close();
    }
}
