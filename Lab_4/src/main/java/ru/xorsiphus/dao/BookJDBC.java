package ru.xorsiphus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.xorsiphus.entity.Book;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component("BookJDBC")
public class BookJDBC implements IBookDAO
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Book> findAll()
    {
        return jdbcTemplate.query("select * from books;", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> findByAuthor(String author)
    {
        return jdbcTemplate.query("SELECT * FROM books WHERE author = ?;",
                new Object[]{author}, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Optional<Book> findById(int id)
    {
        return jdbcTemplate.query("SELECT * FROM books WHERE id = ?;",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findFirst();
    }

    @Override
    public void updateById(int id, Book book)
    {
        jdbcTemplate.update("UPDATE books SET name = ?, author = ?, print_edition = ?, size_in_pages = ?," +
                        "published_on = ? WHERE id = ?;", book.getName(), book.getAuthor(), book.getPrintEdition(),
        book.getSizeInPages(), book.getPublishedOn(), book.getId());
    }

    @Override
    public void add(Book book)
    {
        jdbcTemplate.update("INSERT INTO books (name, author, print_edition, size_in_pages, published_on) " +
                        "VALUES (?, ?, ?, ?, ?);", book.getName(), book.getAuthor(), book.getPrintEdition(),
                book.getSizeInPages(), book.getPublishedOn());
    }

    @Override
    public void removeById(int id)
    {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?;", id);
    }
}
