package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository <T extends IEntity> extends JpaRepository<T, Integer>
{
    List<T> findAll();
    Optional<T> findById(int id);
    @Transactional
    default void updateById(int id, T entity)
    {
        entity.setId(id);
        save(entity);
    }
    @Transactional
    default void insert(T entity)
    {
        save(entity);
    }
    @Transactional
    void removeById(int id);
}
