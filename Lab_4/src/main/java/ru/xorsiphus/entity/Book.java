package ru.xorsiphus.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String author;
    @Column
    private String printEdition;
    @Column(nullable = false)
    private int sizeInPages;
    @Column
    private Date publishedOn;

    public Book()
    {

    }

    public Book(String name, String author, String printEdition, int sizeInPages, Date publishedOn)
    {
        this.id = 0;
        this.name = name;
        this.author = author;
        this.sizeInPages = sizeInPages;
        this.printEdition = printEdition;
        this.publishedOn = publishedOn;
    }

    public Book(int id, String name, String author, String printEdition, int sizeInPages, Date publishedOn)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.sizeInPages = sizeInPages;
        this.printEdition = printEdition;
        this.publishedOn = publishedOn;
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

    public int getSizeInPages()
    {
        return sizeInPages;
    }

    public void setSizeInPages(int sizeInPages)
    {
        this.sizeInPages = sizeInPages;
    }

    public String getPrintEdition()
    {
        return printEdition;
    }

    public void setPrintEdition(String printEdition)
    {
        this.printEdition = printEdition;
    }

    public Date getPublishedOn()
    {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn)
    {
        this.publishedOn = publishedOn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", sizeInPages=" + sizeInPages +
                ", printEdition='" + printEdition + '\'' +
                '}';
    }
}
