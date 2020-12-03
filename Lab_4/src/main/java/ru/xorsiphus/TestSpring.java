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
//        Book book = new Book("War and Peace", "Tolst", "Printer1337",
//                1000, new Date(12345678));
        for (var book : bookJdbc.findAll())
        {
            System.out.println(book);
        }

        context.close();
    }
}
