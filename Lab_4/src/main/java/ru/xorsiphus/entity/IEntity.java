package ru.xorsiphus.entity;

import org.springframework.stereotype.Component;
import ru.xorsiphus.dao.second.db.services.AbstractService;

public interface IEntity
{
    static IEntity parser()
    {
        return null;
    }

    int getId();

    void setId(int id);

    String getEntityRepositoryClassName();

    AbstractService getEntityClass();
}
