package ru.xorsiphus.dao.second.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Personal;

import java.util.List;
import java.util.Optional;

@Repository("personalJPA")
public interface PersonalJPA extends JpaRepository<Personal, Integer>
{
    List<Personal> findAll();
    Optional<Personal> findById(int id);
    void updateById(int id, Personal personal);
    void insert(Personal personal);
    void removeById(int id);
}
