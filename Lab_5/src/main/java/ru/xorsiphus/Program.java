package ru.xorsiphus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.xorsiphus.configuration.SpringConfig;


@SpringBootApplication
public class Program
{
    public static void main(String[] args)
    {
        SpringApplication.run(Program.class, args);
    }

//        bookDAO = context.getBean("booksJPA", BooksJPA.class);
//
//        System.out.println("1 - Ввести поля сущности и добавить её в таблицу БД");
//        System.out.println("2 - Вывести все записи из таблицы БД");
//        System.out.println("3 - Редактировать запись таблицы БД по Id");
//        System.out.println("4 - Удалить запись по Id");
//        System.out.println("5 - Осуществить поиск по типу");
//        System.out.println("6 - Вывести запись из таблицы БД по Id");
//        System.out.println("0 - Выход из программы");
//
//        while (true) {
//            switch (new PropertiesParser<Integer>()
//                    .hasMessage("Введите номер команды: ")
//                    .hasParser(Integer::parseInt)
//                    .hasChecker(number -> 0 <= number && number <= 6)
//                    .readCycle()) {
//                case 1 -> bookDAO
//                        .insert(Books.parser());
//                case 2 -> bookDAO
//                        .findAll()
//                        .forEach(System.out::println);
//                case 3 -> bookDAO
//                        .findById(new PropertiesParser<Integer>()
//                                .hasMessage("Введите Id для редактирования: ")
//                                .hasChecker(id -> id > 0)
//                                .hasParser(Integer::parseInt)
//                                .readCycle())
//                        .ifPresentOrElse(
//                                entity -> bookDAO.updateById(entity.getId(), Books.parser()),
//                                () -> System.out.println("Нет такой записи")
//                        );
//                case 4 -> bookDAO
//                        .findById(new PropertiesParser<Integer>()
//                                .hasMessage("Введите Id для удаления: ")
//                                .hasChecker(id -> id > 0)
//                                .hasParser(Integer::parseInt)
//                                .readCycle())
//                        .ifPresentOrElse(
//                                entity -> bookDAO.removeById(entity.getId()),
//                                () -> System.out.println("Нет такой записи")
//                        );
//                case 5 -> bookDAO
//                        .findByAuthor(new PropertiesParser<String>()
//                                .hasMessage("Введите тип для поиска: ")
//                                .hasChecker(string -> !string.isBlank())
//                                .readCycle()
//                        )
//                        .forEach(System.out::println);
//                case 6 -> bookDAO
//                        .findById(new PropertiesParser<Integer>()
//                                .hasMessage("Введите Id записи: ")
//                                .hasChecker(id -> id > 0)
//                                .hasParser(Integer::parseInt)
//                                .readCycle())
//                        .ifPresentOrElse(
//                                System.out::println,
//                                () -> System.out.println("Нет такой записи")
//                        );
//                case 0 -> {
//                    return;
//                }
//            }
//        }
}
