package ru.xorsiphus.dao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.repositories.BooksJPA;
import ru.xorsiphus.entity.Books;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

@Service("booksServiceImpl")
public class BooksServiceImpl implements AbstractService
{
    @Autowired
    @Qualifier("booksJPA")
    private BooksJPA repository;

    public List<Books> findAll()
    {
        return repository.findAll();
    }

    public Optional<Books> findById(int id)
    {
        return repository.findById(id);
    }

    public <T extends IEntity> void updateById(int id, T entity)
    {
        repository.updateById(id, (Books) entity);
    }

    public <T extends IEntity> void insert(T entity)
    {
        repository.insert((Books) entity);
    }

    public void removeById(int id)
    {
        repository.removeById(id);
    }

}
