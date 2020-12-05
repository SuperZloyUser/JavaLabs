package ru.xorsiphus.dao;

import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

@Repository("iEntityJPA")
public interface IEntityJPA
{
    List<IEntity> findAll();
    List<IEntity> findByAuthor(String author);
    Optional<IEntity> findById(int id);
    void updateById(int id, IEntity books);
    void add(IEntity books);
    void removeById(int id);
}
