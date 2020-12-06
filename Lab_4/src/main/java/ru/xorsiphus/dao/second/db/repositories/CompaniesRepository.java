package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Companies;

@Qualifier("companiesRepository")
@Repository("companiesRepository")
public interface CompaniesRepository extends BaseRepository<Companies>
{

}
