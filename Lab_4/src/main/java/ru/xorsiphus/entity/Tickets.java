package ru.xorsiphus.entity;

import ru.xorsiphus.parser.DateParser;
import ru.xorsiphus.parser.PropertiesParser;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Tickets implements IEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    @Column(nullable = false, updatable = false)
    private int company_id;
    @Column(nullable = false, updatable = false)
    private int film_id;

    public Tickets()
    {
    }

    public Tickets(int company_id, int film_id)
    {
        this.company_id = company_id;
        this.film_id = film_id;
    }

    public Tickets(int id, int company_id, int film_id)
    {
        this.id = id;
        this.company_id = company_id;
        this.film_id = film_id;
    }

    public IEntity parser()
    {
        return new Tickets(
                new PropertiesParser<Integer>()
                        .hasMessage("Кинотеатр билета(id): ")
                        .hasChecker(number -> 0 < number)
                        .hasParser(Integer::parseInt)
                        .readCycle(),
                new PropertiesParser<Integer>()
                        .hasMessage("Фильм билета(id): ")
                        .hasChecker(number -> 0 < number)
                        .hasParser(Integer::parseInt)
                        .readCycle()
        );
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

    public int getFilm_id()
    {
        return film_id;
    }

    public void setFilm_id(int film_id)
    {
        this.film_id = film_id;
    }

    @Override
    public String toString()
    {
        return "Tickets{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", film_id=" + film_id +
                '}';
    }
}
