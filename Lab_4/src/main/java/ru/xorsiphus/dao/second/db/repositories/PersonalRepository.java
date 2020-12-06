package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Personal;

@Qualifier("personalRepository")
@Repository("personalRepository")
public interface PersonalRepository extends BaseRepository<Personal>
{

}
