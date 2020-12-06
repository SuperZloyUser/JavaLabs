package ru.xorsiphus.dao.second.db.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.xorsiphus.entity.Tickets;

@Qualifier("ticketsRepository")
@Repository("ticketsRepository")
public interface TicketsRepository extends BaseRepository<Tickets>
{

}
