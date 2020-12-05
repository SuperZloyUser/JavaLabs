package ru.xorsiphus.dao.second.db;

import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Personal;


@Repository("personalRepository")
public interface PersonalRepository extends BaseRepository<Personal>
{

}
