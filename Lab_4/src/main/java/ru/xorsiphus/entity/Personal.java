package ru.xorsiphus.entity;

import ru.xorsiphus.parser.DateParser;
import ru.xorsiphus.parser.PropertiesParser;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Personal implements IEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    @Column(nullable = false, updatable = false)
    private int company_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date b_date;
    @Column()
    private String position;

    public Personal()
    {
    }

    public Personal(int company_id, String name, Date b_date, String position)
    {
        this.company_id = company_id;
        this.name = name;
        this.b_date = b_date;
        this.position = position;
    }

    public Personal(int id, int company_id, String name, Date b_date, String position)
    {
        this.id = id;
        this.company_id = company_id;
        this.name = name;
        this.b_date = b_date;
        this.position = position;
    }

    public IEntity parser()
    {
        return new Personal(
                new PropertiesParser<Integer>()
                        .hasMessage("Компания - работодатель(id): ")
                        .hasChecker(number -> 0 < number)
                        .hasParser(Integer::parseInt)
                        .readCycle(),
                new PropertiesParser<String>()
                        .hasMessage("Имя: ")
                        .hasChecker(string -> !string.isBlank())
                        .readCycle(),
                new PropertiesParser<Date>()
                        .hasMessage("Введите дату рождения(Day-Month-Year): ")
                        .hasChecker(date -> date.getTime() >= new Date(0).getTime())
                        .hasParser(DateParser::parseDate)
                        .readCycle(),
                new PropertiesParser<String>()
                        .hasMessage("Должность: ")
                        .hasChecker(string -> !string.isBlank())
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getB_date()
    {
        return b_date;
    }

    public void setB_date(Date b_date)
    {
        this.b_date = b_date;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    @Override
    public String toString()
    {
        return "Personal{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", name='" + name + '\'' +
                ", b_date=" + b_date +
                ", position='" + position + '\'' +
                '}';
    }
}
