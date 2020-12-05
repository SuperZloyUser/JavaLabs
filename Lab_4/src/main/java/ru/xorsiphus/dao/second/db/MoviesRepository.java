package ru.xorsiphus.dao.second.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Movies;

import java.util.List;
import java.util.Optional;

@Repository("moviesJPA")
public interface MoviesJPA extends JpaRepository<Movies, Integer>
{
    List<Movies> findAll();
    Optional<Movies> findById(int id);
    void updateById(int id, Movies movies);
    void insert(Movies movies);
    void removeById(int id);
}
