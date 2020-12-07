package ru.xorsiphus.dao.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.xorsiphus.entity.Books;

import java.util.List;
import java.util.Optional;

@Qualifier("booksJPA")
@Repository("booksJPA")
public interface BooksJPA extends JpaRepository<Books, Integer>, IBookDAO<Books>
{
    List<Books> findByAuthor(String type);

    Optional<Books> findById(int id);

    @Transactional
    default void updateById(int id, Books books)
    {
        books.setId(id);
        save(books);
    }

    @Transactional
    default void insert(Books books)
    {
        save(books);
    }

    @Transactional
    void removeById(int id);
}
