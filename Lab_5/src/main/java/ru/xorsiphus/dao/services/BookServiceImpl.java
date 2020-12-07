package ru.xorsiphus.dao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.repositories.BooksJPA;
import ru.xorsiphus.entity.Book;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

@Qualifier("bookService")
@Service("bookServiceImpl")
public class BookServiceImpl implements AbstractService
{
    private final BooksJPA repository;

    public BookServiceImpl(@Qualifier("bookJPA") BooksJPA repository)
    {
        this.repository = repository;
    }

    public List<Book> findAll()
    {
        return repository.findAll();
    }

    public Optional<Book> findById(int id)
    {
        return repository.findById(id);
    }

    public <T extends IEntity> void updateById(int id, T entity)
    {
        repository.updateById(id, (Book) entity);
    }

    public <T extends IEntity> void insert(T entity)
    {
        repository.insert((Book) entity);
    }

    public void removeById(int id)
    {
        repository.removeById(id);
    }

}
