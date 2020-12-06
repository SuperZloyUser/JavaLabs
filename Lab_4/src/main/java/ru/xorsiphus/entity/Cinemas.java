package ru.xorsiphus.entity;

import ru.xorsiphus.dao.second.db.services.AbstractService;
import ru.xorsiphus.dao.second.db.services.CinemasServiceImpl;
import ru.xorsiphus.parser.PropertiesParser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "cinemas")
@Table(name = "cinemas")
public class Cinemas implements IEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    @OneToMany(mappedBy = "cinemas", fetch = FetchType.LAZY)
    private Collection<Tickets> tickets;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private int shared_film;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "shared_film", insertable = false, updatable = false)
    private Movies movies;

    public Cinemas()
    {
    }

    public Cinemas(String name, String country, String city, int shared_film)
    {
        this.name = name;
        this.country = country;
        this.city = city;
        this.shared_film = shared_film;
    }

    public Cinemas(int id, String name, String country, String city, int shared_film)
    {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.shared_film = shared_film;
    }

    public String getEntityRepositoryClassName()
    {
        return "cinemasService";
    }

    public AbstractService getEntityClass()
    {
        return new CinemasServiceImpl();
    }

    public static IEntity parser()
    {
        return new Cinemas(
                new PropertiesParser<String>()
                        .hasMessage("Название: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new PropertiesParser<String>()
                        .hasMessage("Страна: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new PropertiesParser<String>()
                        .hasMessage("Город: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new PropertiesParser<Integer>()
                        .hasMessage("Досутп к фильму(id): ")
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

    public Movies getMovies()
    {
        return movies;
    }

    public void setMovies(Movies movies)
    {
        this.movies = movies;
    }

    public Collection<Tickets> getTickets()
    {
        if (tickets == null)
            tickets = new ArrayList<Tickets>();
        return tickets;
    }

    public void setTickets(Collection<Tickets> tickets)
    {
        this.tickets = tickets;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getShared_film()
    {
        return shared_film;
    }

    public void setShared_film(int shared_film)
    {
        this.shared_film = shared_film;
    }

    @Override
    public String toString() {
        return "Cinemas{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", shared_film=" + shared_film +
                '}';
    }
}
