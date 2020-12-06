package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Movies;

@Qualifier("moviesRepository")
@Repository("moviesRepository")
public interface MoviesRepository extends BaseRepository<Movies>
{

}
