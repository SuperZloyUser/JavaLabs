package ru.xorsiphus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.xorsiphus.configuration.SpringConfig;
import ru.xorsiphus.dao.second.db.services.AbstractService;
import ru.xorsiphus.dao.second.db.services.TicketsServiceImpl;
import ru.xorsiphus.entity.Cinemas;
import ru.xorsiphus.entity.IEntity;
import ru.xorsiphus.parser.EntityParser;
import ru.xorsiphus.parser.PropertiesParser;


@SpringBootApplication
public class ProgramSecondDB implements CommandLineRunner
{
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    public static void main(String[] args)
    {
        SpringApplication.run(ProgramSecondDB.class, args);
    }

    @Override
    public void run(String[] args) throws Exception
    {
        TicketsServiceImpl ticketsService = context.getBean("ticketsService", TicketsServiceImpl.class);

        var temp = ticketsService.superJoin();

        for (var ticket : temp)
        {
            System.out.println(ticket[0] + " - " + ticket[1]);
        }

        while (true)
        {
            IEntity entity = entityChooser();

            if (entity == null)
                return;

            AbstractService entityBaseRepository = context.getBean(entity.getEntityRepositoryClassName(),
                    entity.getEntityClass().getClass());

            System.out.println("1 - Ввести поля сущности и добавить её в таблицу БД");
            System.out.println("2 - Вывести все записи из таблицы БД");
            System.out.println("3 - Редактировать запись таблицы БД по Id");
            System.out.println("4 - Удалить запись по Id");
            System.out.println("5 - Вывести запись из таблицы БД по Id");
            System.out.println("0 - Выход из программы");

            while (true) {

                switch (new PropertiesParser<Integer>()
                        .hasMessage("Введите номер команды: ")
                        .hasParser(Integer::parseInt)
                        .hasChecker(number -> 0 <= number && number <= 6)
                        .readCycle())
                {
                    case 1 -> entityBaseRepository
                            .insert(Cinemas.parser());
                    case 2 -> entityBaseRepository
                            .findAll()
                            .forEach(System.out::println);
                    case 3 -> entityBaseRepository
                            .findById(new PropertiesParser<Integer>()
                                    .hasMessage("Введите Id для редактирования: ")
                                    .hasChecker(id -> id > 0)
                                    .hasParser(Integer::parseInt)
                                    .readCycle())
                            .ifPresentOrElse(
                                    tempEntity -> entityBaseRepository.updateById(tempEntity.getId(), (Cinemas) Cinemas.parser()),
                                    () -> System.out.println("Нет такой записи")
                            );
                    case 4 -> entityBaseRepository
                            .findById(new PropertiesParser<Integer>()
                                    .hasMessage("Введите Id для удаления: ")
                                    .hasChecker(id -> id > 0)
                                    .hasParser(Integer::parseInt)
                                    .readCycle())
                            .ifPresentOrElse(
                                    tempEntity -> entityBaseRepository.removeById(tempEntity.getId()),
                                    () -> System.out.println("Нет такой записи")
                            );
                    case 5 -> entityBaseRepository
                            .findById(new PropertiesParser<Integer>()
                                    .hasMessage("Введите Id записи: ")
                                    .hasChecker(id -> id > 0)
                                    .hasParser(Integer::parseInt)
                                    .readCycle())
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Нет такой записи")
                            );
                    case 0 -> { return; }
            }
            }
        }
    }

    public IEntity entityChooser()
    {
        return new PropertiesParser<IEntity>()
                .hasMessage("Введите сущность/Exit: ")
                .hasParser(EntityParser::parseEntity)
                .readCycle();
    }
}
