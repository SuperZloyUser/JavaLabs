package ru.xorsiphus.dao.second.db;

import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Companies;


@Repository("companiesRepository")
public interface CompaniesRepository extends BaseRepository<Companies>
{

}
