package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Companies;


@Repository("companiesRepository")
public interface CompaniesRepository extends BaseRepository<Companies>
{

}
