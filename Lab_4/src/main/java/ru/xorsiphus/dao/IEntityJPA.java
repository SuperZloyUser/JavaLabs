package ru.xorsiphus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.xorsiphus.entity.IEntity;

import java.util.List;
import java.util.Optional;

@Repository("iEntityJPA")
public interface IEntityJPA extends JpaRepository<IEntity, Integer>
{
    List<IEntity> findAll();

    Optional<IEntity> findById(int id);

    @Transactional
    void updateById(int id, IEntity books);

    @Transactional
    void add(IEntity books);

    @Transactional
    void removeById(int id);
}
