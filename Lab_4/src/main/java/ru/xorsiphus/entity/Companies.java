package ru.xorsiphus.entity;

import ru.xorsiphus.dao.second.db.services.AbstractService;
import ru.xorsiphus.dao.second.db.services.CompaniesServiceImpl;
import ru.xorsiphus.parser.DateParser;
import ru.xorsiphus.parser.PropertiesParser;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "companies")
@Table(name = "companies")
public class Companies implements IEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Personal> personals;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Movies> movies;

    @Column(nullable = false)
    private String name;

    @Column
    private Date date;

    public Companies()
    {
    }

    public Companies(String name, Date date)
    {
        this.name = name;
        this.date = date;
    }

    public Companies(int id, String name, Date date)
    {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public static IEntity parser()
    {
        return new Companies(
                new PropertiesParser<String>()
                        .hasMessage("Название: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new PropertiesParser<Date>()
                        .hasMessage("Введите дату основания(Day-Month-Year): ")
                        .hasChecker(date -> date.getTime() >= new Date(0).getTime())
                        .hasParser(DateParser::parseDate)
                        .readCycle()
        );
    }

    public String getEntityRepositoryClassName()
    {
        return "companiesService";
    }

    public AbstractService getEntityClass()
    {
        return new CompaniesServiceImpl();
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

    public Collection<Personal> getPersonals()
    {
        if (personals == null)
            personals = new ArrayList<Personal>();
        return personals;
    }

    public void setPersonals(Collection<Personal> personals)
    {
        this.personals = personals;
    }

    public Collection<Movies> getMovies()
    {
        if (movies == null)
            movies = new ArrayList<Movies>();
        return movies;
    }

    public void setMovies(Collection<Movies> movies)
    {
        this.movies = movies;
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

    @Override
    public String toString() {
        return "Companies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
