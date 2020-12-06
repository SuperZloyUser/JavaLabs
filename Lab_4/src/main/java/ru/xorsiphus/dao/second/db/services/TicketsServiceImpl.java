package ru.xorsiphus.dao.second.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.second.db.repositories.TicketsRepository;
import ru.xorsiphus.entity.IEntity;
import ru.xorsiphus.entity.Tickets;

import java.util.List;
import java.util.Optional;

@Service("ticketsService")
public class TicketsServiceImpl implements AbstractService
{
    @Autowired
    @Qualifier("ticketsRepository")
    private TicketsRepository repository;

    public List<Tickets> findAll()
    {
        return repository.findAll();
    }

    public Optional<Tickets> findById(int id)
    {
        return repository.findById(id);
    }

    public <T extends IEntity> void updateById(int id, T entity)
    {
        repository.updateById(id, (Tickets) entity);
    }

    public <T extends IEntity> void insert(T entity)
    {
        repository.insert((Tickets) entity);
    }

    public void removeById(int id)
    {
        repository.removeById(id);
    }

}
