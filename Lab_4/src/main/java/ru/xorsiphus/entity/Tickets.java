package ru.xorsiphus.entity;

import ru.xorsiphus.dao.second.db.services.AbstractService;
import ru.xorsiphus.dao.second.db.services.TicketsServiceImpl;
import ru.xorsiphus.parser.PropertiesParser;

import javax.persistence.*;

@Entity(name = "tickets")
@Table(name = "tickets")
public class Tickets implements IEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    @Column(nullable = false, updatable = false)
    private int cinema_id;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_id", insertable = false, updatable = false)
    private Cinemas cinemas;

    @Column(nullable = false, updatable = false)
    private int film_id;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Movies movies;

    public Tickets()
    {
    }

    public Tickets(int cinema_id, int film_id)
    {
        this.cinema_id = cinema_id;
        this.film_id = film_id;
    }

    public Tickets(int id, int cinema_id, int film_id)
    {
        this.id = id;
        this.cinema_id = cinema_id;
        this.film_id = film_id;
    }

    public static IEntity parser()
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

    public String getEntityRepositoryClassName()
    {
        return "ticketsRepository";
    }

    public AbstractService getEntityClass()
    {
        return new TicketsServiceImpl();
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

    public Cinemas getCinemas()
    {
        return cinemas;
    }

    public void setCinemas(Cinemas cinemas)
    {
        this.cinemas = cinemas;
    }

    public Movies getMovies()
    {
        return movies;
    }

    public void setMovies(Movies movies)
    {
        this.movies = movies;
    }

    public int getCinema_id()
    {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id)
    {
        this.cinema_id = cinema_id;
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
                ", company_id=" + cinema_id +
                ", film_id=" + film_id +
                '}';
    }
}
