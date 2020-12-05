package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Movies;


@Repository("moviesRepository")
public interface MoviesRepository extends BaseRepository<Movies>
{

}
