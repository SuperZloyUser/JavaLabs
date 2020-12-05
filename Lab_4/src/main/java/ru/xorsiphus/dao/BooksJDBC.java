package ru.xorsiphus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.xorsiphus.entity.Books;

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

    public List<Books> findAll()
    {
        return jdbcTemplate.query("select * from books;", new BeanPropertyRowMapper<>(Books.class));
    }

    @Override
    public List<Books> findByAuthor(String author)
    {
        return jdbcTemplate.query("SELECT * FROM books WHERE author = ?;",
                new Object[]{author}, new BeanPropertyRowMapper<>(Books.class));
    }

    @Override
    public Optional<Books> findById(int id)
    {
        return jdbcTemplate.query("SELECT * FROM books WHERE id = ?;",
                new Object[]{id}, new BeanPropertyRowMapper<>(Books.class)).stream().findFirst();
    }

    @Override
    public void updateById(int id, Books books)
    {
        jdbcTemplate.update("UPDATE books SET name = ?, author = ?, print_edition = ?, size_in_pages = ?," +
                        "published_on = ? WHERE id = ?;", books.getName(), books.getAuthor(), books.getPrint_edition(),
        books.getSize_in_pages(), books.getPublished_on(), books.getId());
    }

    @Override
    public void add(Books books)
    {
        jdbcTemplate.update("INSERT INTO books (name, author, print_edition, size_in_pages, published_on) " +
                        "VALUES (?, ?, ?, ?, ?);", books.getName(), books.getAuthor(), books.getPrint_edition(),
                books.getSize_in_pages(), books.getPublished_on());
    }

    @Override
    public void removeById(int id)
    {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?;", id);
    }
}
