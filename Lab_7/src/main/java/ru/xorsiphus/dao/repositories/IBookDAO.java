package ru.xorsiphus.dao.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface IBookDAO <T extends IEntity>
{
    List<T> findAll();
    List<T> findByAuthor(String author);
    Optional<T> findById(int id);
    void updateById(int id, T books);
    void insert(T books);
    void removeById(int id);
}
