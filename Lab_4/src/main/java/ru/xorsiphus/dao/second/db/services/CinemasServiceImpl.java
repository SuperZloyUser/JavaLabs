package ru.xorsiphus.dao.second.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.second.db.repositories.CinemasRepository;
import ru.xorsiphus.entity.Cinemas;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

@Service("cinemasService")
public class CinemasServiceImpl implements AbstractService
{
    @Autowired
    @Qualifier("cinemasRepository")
    private CinemasRepository repository;

    public List<Cinemas> findAll()
    {
        return repository.findAll();
    }

    public Optional<Cinemas> findById(int id)
    {
        return repository.findById(id);
    }

    public <T extends IEntity> void updateById(int id, T entity)
    {
        repository.updateById(id, (Cinemas) entity);
    }

    public <T extends IEntity> void insert(T entity)
    {
        repository.insert((Cinemas) entity);
    }

    public void removeById(int id)
    {
        repository.removeById(id);
    }

}
