package ru.xorsiphus.dao.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.xorsiphus.entity.Book;

import java.util.List;
import java.util.Optional;

@Qualifier("bookJPA")
@Repository("bookJPA")
public interface BooksJPA extends JpaRepository<Book, Integer>, IBookDAO<Book>
{
    List<Book> findAll();

    List<Book> findByAuthor(String type);

    Optional<Book> findById(int id);

    @Transactional
    default void updateById(int id, Book book)
    {
        book.setId(id);
        save(book);
    }

    @Transactional
    default void insert(Book book)
    {
        save(book);
    }

    @Transactional
    void removeById(int id);
}
