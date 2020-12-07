package ru.xorsiphus.dao.services;

import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

public interface AbstractService
{
    List<? extends IEntity> findAll();
    Optional<? extends IEntity> findById(int id);

    <T extends IEntity> void updateById(int id, T entity);

    <T extends IEntity> void insert(T entity);

    void removeById(int id);
}
