package ru.xorsiphus.entity;

import ru.xorsiphus.dao.second.db.services.AbstractService;
import ru.xorsiphus.dao.second.db.services.CinemasServiceImpl;
import ru.xorsiphus.parser.DateParser;
import ru.xorsiphus.parser.PropertiesParser;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "movies")
@Table(name = "movies")
public class Movies implements IEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    @Column(nullable = false, updatable = false)
    private int company_id;
    @Column(nullable = false)
    private String name;
    @Column()
    private Date date;
    @Column(nullable = false)
    private String genre;

    public Movies()
    {
    }

    public Movies(int company_id, String name, Date date, String genre)
    {
        this.company_id = company_id;
        this.name = name;
        this.date = date;
        this.genre = genre;
    }

    public Movies(int id, int company_id, String name, Date date, String genre)
    {
        this.id = id;
        this.company_id = company_id;
        this.name = name;
        this.date = date;
        this.genre = genre;
    }

    public static IEntity parser()
    {
        return new Movies(
                new PropertiesParser<Integer>()
                        .hasMessage("Компания - производитель(id): ")
                        .hasChecker(number -> 0 < number)
                        .hasParser(Integer::parseInt)
                        .readCycle(),
                new PropertiesParser<String>()
                        .hasMessage("Название: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new PropertiesParser<Date>()
                        .hasMessage("Введите дату публикации(Day-Month-Year): ")
                        .hasChecker(date -> date.getTime() >= new Date(0).getTime())
                        .hasParser(DateParser::parseDate)
                        .readCycle(),
                new PropertiesParser<String>()
                        .hasMessage("Жанры: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle()
        );
    }

    public String getEntityRepositoryClassName()
    {
        return "moviesRepository";
    }

    public AbstractService getEntityClass()
    {
        return new CinemasServiceImpl();
    }

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public void setId(int id)
    {
        this.id = id;
    }

    public int getCompany_id()
    {
        return company_id;
    }

    public void setCompany_id(int company_id)
    {
        this.company_id = company_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    @Override
    public String toString()
    {
        return "Movies{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", genre='" + genre + '\'' +
                '}';
    }
}
