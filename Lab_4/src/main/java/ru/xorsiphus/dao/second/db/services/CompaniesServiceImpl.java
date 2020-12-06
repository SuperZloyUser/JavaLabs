package ru.xorsiphus.dao.second.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.second.db.repositories.CompaniesRepository;
import ru.xorsiphus.entity.Companies;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

@Service("companiesService")
public class CompaniesServiceImpl implements AbstractService
{
    @Autowired
    @Qualifier("companiesRepository")
    private CompaniesRepository repository;

    public List<Companies> findAll()
    {
        return repository.findAll();
    }

    public Optional<Companies> findById(int id)
    {
        return repository.findById(id);
    }

    public <T extends IEntity> void updateById(int id, T entity)
    {
        repository.updateById(id, (Companies) entity);
    }

    public <T extends IEntity> void insert(T entity)
    {
        repository.insert((Companies) entity);
    }

    public void removeById(int id)
    {
        repository.removeById(id);
    }

}
