package ru.xorsiphus.dao.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.xorsiphus.entity.User;

import java.util.List;
import java.util.Optional;

@Qualifier("userRepository")
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>, AbstractRepository<User>
{
    List<User> findAll();

    Optional<User> findByUsername(String username);

    Optional<User> findById(int id);

    @Transactional
    default void updateById(int id, User user)
    {
        user.setId(id);
        save(user);
    }

    @Transactional
    default void insert(User user)
    {
        save(user);
    }

    @Transactional
    void removeById(int id);
}
