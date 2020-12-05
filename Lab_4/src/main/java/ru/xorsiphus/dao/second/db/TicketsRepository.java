package ru.xorsiphus.dao.second.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Personal;
import ru.xorsiphus.entity.Tickets;

import java.util.List;
import java.util.Optional;

@Repository("ticketsJPA")
public interface TicketsJPA extends JpaRepository<Tickets, Integer>
{
    List<Tickets> findAll();
    Optional<Tickets> findById(int id);
    void updateById(int id, Tickets tickets);
    void insert(Tickets tickets);
    void removeById(int id);
}
