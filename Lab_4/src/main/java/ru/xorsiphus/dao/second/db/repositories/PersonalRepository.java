package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Personal;


@Repository("personalRepository")
public interface PersonalRepository extends BaseRepository<Personal>
{

}
