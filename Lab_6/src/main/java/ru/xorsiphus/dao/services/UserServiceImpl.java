package ru.xorsiphus.dao.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.repositories.UserRepository;
import ru.xorsiphus.entity.IEntity;
import ru.xorsiphus.entity.User;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Qualifier("userService")
@Service("userServiceImpl")
public class UserServiceImpl implements AbstractService
{
    private final UserRepository repository;
    private final SessionFactory factory;

    public UserServiceImpl(@Qualifier("userRepository") UserRepository repository, SessionFactory factory)
    {
        this.repository = repository;
        this.factory = factory;
    }

    public List<User> findAll()
    {
        Session session = factory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user).orderBy(criteriaBuilder.asc(user.get("id")));
        TypedQuery<User> query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public Optional<User> findById(int id)
    {
        return repository.findById(id);
    }

    public <T extends IEntity> void updateById(int id, T entity)
    {
        repository.updateById(id, (User) entity);
    }

    public <T extends IEntity> void insert(T entity)
    {
        repository.insert((User) entity);
    }

    public long count()
    {
        return repository.count();
    }

    public void removeById(int id)
    {
        repository.removeById(id);
    }

}
