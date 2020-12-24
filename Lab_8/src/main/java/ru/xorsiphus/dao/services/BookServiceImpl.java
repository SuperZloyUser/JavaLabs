package ru.xorsiphus.dao.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.xorsiphus.dao.repositories.BooksJPA;
import ru.xorsiphus.entity.Book;
import ru.xorsiphus.entity.IEntity;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Qualifier("bookService")
@Service("bookServiceImpl")
public class BookServiceImpl implements AbstractService
{
    private final BooksJPA repository;
    private final SessionFactory factory;

    public BookServiceImpl(@Qualifier("bookJPA") BooksJPA repository, SessionFactory factory)
    {
        this.repository = repository;
        this.factory = factory;
    }

    public List<Book> findAll()
    {
        Session session = factory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> book = criteriaQuery.from(Book.class);
        criteriaQuery.select(book).orderBy(criteriaBuilder.asc(book.get("id")));
        TypedQuery<Book> query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public Optional<Book> findById(int id)
    {
        return repository.findById(id);
    }

    public List<Book> findByAuthor(String author)
    {
        Session session = factory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> book = criteriaQuery.from(Book.class);
        criteriaQuery
                .select(book)
                .where(criteriaBuilder.equal(book.get("author"), author))
                .orderBy(criteriaBuilder.asc(book.get("id")));
        TypedQuery<Book> query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public <T extends IEntity> void updateById(int id, T entity)
    {
        repository.updateById(id, (Book) entity);
    }

    public <T extends IEntity> void insert(T entity)
    {
        repository.insert((Book) entity);
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
