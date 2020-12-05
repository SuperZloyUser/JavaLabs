package ru.xorsiphus.entity;


public interface IEntity
{
    static IEntity parser()
    {
        return null;
    }

    int getId();

    void setId(int id);
}
