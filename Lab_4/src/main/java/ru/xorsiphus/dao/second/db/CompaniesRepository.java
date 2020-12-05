package ru.xorsiphus.dao.second.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Companies;

import java.util.List;
import java.util.Optional;

@Repository("companiesJPA")
public interface CompaniesJPA extends JpaRepository<Companies, Integer>
{
    List<Companies> findAll();
    Optional<Companies> findById(int id);
    void updateById(int id, Companies companies);
    void insert(Companies companies);
    void removeById(int id);
}
