package ru.xorsiphus.dao.second.db.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.second.db.repositories.TicketsRepository;
import ru.xorsiphus.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service("ticketsService")
public class TicketsServiceImpl implements AbstractService
{
    @Autowired
    @Qualifier("ticketsRepository")
    private TicketsRepository repository;

    @Autowired
    SessionFactory sessionFactory;

//    @Autowired
//    EntityManager entityManager;

    public List<Object[]> superJoin()
    {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery =
                builder.createQuery(Object[].class);
//        Root<Tickets> rootTick = criteriaQuery.from(Tickets.class);
//        Root<Cinemas> rootCin = criteriaQuery.from(Cinemas.class);
        Root<Movies> rootMov = criteriaQuery.from(Movies.class);
        Root<Companies> rootComp = criteriaQuery.from(Companies.class);
//        Root<Personal> rootPers = criteriaQuery.from(Personal.class);

        criteriaQuery.multiselect(rootComp, rootMov);

        criteriaQuery.where(builder.equal(rootComp.get("id"), rootMov.get("company_id")));
//        criteriaQuery.where(builder.equal(rootComp.get("id"), rootPers.get("company_id")));
//        criteriaQuery.where(builder.equal(rootComp.get("id"), rootPers.get("company_id")));

//        return entityManager.createQuery(criteriaQuery).setMaxResults(100).getResultList();
        return session.createQuery(criteriaQuery).getResultList();
    }

    public List<Tickets> findAll()
    {
        return repository.findAll();
    }

    public Optional<Tickets> findById(int id)
    {
        return repository.findById(id);
    }

    public <T extends IEntity> void updateById(int id, T entity)
    {
        repository.updateById(id, (Tickets) entity);
    }

    public <T extends IEntity> void insert(T entity)
    {
        repository.insert((Tickets) entity);
    }

    public void removeById(int id)
    {
        repository.removeById(id);
    }

}
