package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Cinemas;

@Qualifier("cinemasRep")
@Repository("cinemasRepository")
public interface CinemasRepository extends BaseRepository<Cinemas>
{

}
