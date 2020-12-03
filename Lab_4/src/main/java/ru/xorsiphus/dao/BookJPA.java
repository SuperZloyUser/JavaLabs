package ru.xorsiphus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.xorsiphus.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository("BookJPA")
public interface BookJPA extends JpaRepository<Book, Integer>, IBookDAO
{
    List<Book> findByAuthor(String type);

    Optional<Book> findById(int id);

    @Transactional
    default void updateById(int id, Book book)
    {
        book.setId(id);
        save(book);
    }

    default void add(Book book)
    {
        save(book);
    }

    @Transactional
    void removeById(int id);
}
