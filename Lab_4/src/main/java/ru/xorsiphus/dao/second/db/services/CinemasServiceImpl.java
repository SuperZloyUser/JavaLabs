package ru.xorsiphus.dao.second.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.second.db.repositories.BaseRepository;
import ru.xorsiphus.dao.second.db.repositories.CinemasRepository;
import ru.xorsiphus.entity.Cinemas;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

//@Service("cinemasService")
public class CinemasServiceImpl implements AbstractService
{
//    @Autowired
//    @Qualifier("cinemasRep")
    private CinemasRepository cinemasRepository;

    public List<Cinemas> findAll()
    {
        return cinemasRepository.findAll();
    }

    public Optional<Cinemas> findById(int id)
    {
        return cinemasRepository.findById(id);
    }

    public void updateById(int id, IEntity entity)
    {
        cinemasRepository.updateById(id, (Cinemas) entity);
    }

    public void insert(IEntity entity)
    {
        cinemasRepository.insert((Cinemas) entity);
    }

    public void removeById(int id)
    {
        cinemasRepository.removeById(id);
    }

}
