package ru.xorsiphus.dao.second.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Cinemas;

import java.util.List;
import java.util.Optional;

@Repository("cinemasJPA")
public interface CinemasJPA extends JpaRepository<Cinemas, Integer>
{
    List<Cinemas> findAll();
    Optional<Cinemas> findById(int id);
    void updateById(int id, Cinemas cinemas);
    void insert(Cinemas cinemas);
    void removeById(int id);
}
