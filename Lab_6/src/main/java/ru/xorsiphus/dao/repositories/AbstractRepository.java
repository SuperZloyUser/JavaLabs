package ru.xorsiphus.dao.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface AbstractRepository<T extends IEntity>
{
    List<T> findAll();
    Optional<T> findById(int id);
    Optional<T> findByUsername(String username);
    void updateById(int id, T books);
    void insert(T books);
    void removeById(int id);
}
