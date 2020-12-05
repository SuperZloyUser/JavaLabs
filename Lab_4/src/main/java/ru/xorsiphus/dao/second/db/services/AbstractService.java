package ru.xorsiphus.dao.second.db.services;

import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

public interface AbstractService
{
    List<? extends IEntity> findAll();
    Optional<? extends IEntity> findById(int id);

    void updateById(int id, IEntity entity);

    void insert(IEntity entity);

    void removeById(int id);
}
