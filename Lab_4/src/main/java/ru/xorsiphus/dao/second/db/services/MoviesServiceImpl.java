package ru.xorsiphus.dao.second.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.second.db.repositories.MoviesRepository;
import ru.xorsiphus.entity.IEntity;
import ru.xorsiphus.entity.Movies;

import java.util.List;
import java.util.Optional;

@Service("moviesService")
public class MoviesServiceImpl implements AbstractService
{
    @Autowired
    @Qualifier("moviesRepository")
    private MoviesRepository repository;

    public List<Movies> findAll()
    {
        return repository.findAll();
    }

    public Optional<Movies> findById(int id)
    {
        return repository.findById(id);
    }

    public <T extends IEntity> void updateById(int id, T entity)
    {
        repository.updateById(id, (Movies) entity);
    }

    public <T extends IEntity> void insert(T entity)
    {
        repository.insert((Movies) entity);
    }

    public void removeById(int id)
    {
        repository.removeById(id);
    }

}
