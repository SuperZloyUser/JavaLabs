package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Tickets;


@Repository("ticketsRepository")
public interface TicketsRepository extends BaseRepository<Tickets>
{

}
