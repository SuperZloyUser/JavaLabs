package ru.xorsiphus.entity;

import org.springframework.data.annotation.TypeAlias;
import ru.xorsiphus.dao.BooksJPA;
import ru.xorsiphus.dao.second.db.repositories.CinemasRepository;
import ru.xorsiphus.dao.second.db.services.AbstractService;
import ru.xorsiphus.dao.second.db.services.CinemasServiceImpl;
import ru.xorsiphus.parser.DateParser;
import ru.xorsiphus.parser.PropertiesParser;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "books")
@Table(name = "books")
public class Books implements IEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String author;
    @Column
    private String print_edition;
    @Column(nullable = false)
    private int size_in_pages;
    @Column
    private Date published_on;

    public Books()
    {

    }

    public Books(String name, String author, String print_edition, int size_in_pages, Date published_on)
    {
        this.id = 0;
        this.name = name;
        this.author = author;
        this.size_in_pages = size_in_pages;
        this.print_edition = print_edition;
        this.published_on = published_on;
    }

    public Books(int id, String name, String author, String print_edition, int size_in_pages, Date published_on)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.size_in_pages = size_in_pages;
        this.print_edition = print_edition;
        this.published_on = published_on;
    }

    public static Books parser()
    {
        return new Books(
                new PropertiesParser<String>()
                        .hasMessage("Название: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new PropertiesParser<String>()
                        .hasMessage("Автор: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new PropertiesParser<String>()
                        .hasMessage("Издание: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new PropertiesParser<Integer>()
                        .hasMessage("Размер(страниц): ")
                        .hasChecker(number -> 0 < number && number < 10000)
                        .hasParser(Integer::parseInt)
                        .readCycle(),
                new PropertiesParser<Date>()
                        .hasMessage("Введите дату публикации(Day-Month-Year): ")
                        .hasChecker(date -> date.getTime() >= new Date(0).getTime())
                        .hasParser(DateParser::parseDate)
                        .readCycle()
        );
    }

    public String getEntityRepositoryClassName()
    {
        return "booksJPA";
    }

    public AbstractService getEntityClass()
    {
        return new CinemasServiceImpl();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getSize_in_pages()
    {
        return size_in_pages;
    }

    public void setSize_in_pages(int sizeInPages)
    {
        this.size_in_pages = sizeInPages;
    }

    public String getPrint_edition()
    {
        return print_edition;
    }

    public void setPrint_edition(String printEdition)
    {
        this.print_edition = printEdition;
    }

    public Date getPublished_on()
    {
        return published_on;
    }

    public void setPublished_on(Date publishedOn)
    {
        this.published_on = publishedOn;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", sizeInPages=" + size_in_pages +
                ", printEdition='" + print_edition + '\'' +
                '}';
    }
}
