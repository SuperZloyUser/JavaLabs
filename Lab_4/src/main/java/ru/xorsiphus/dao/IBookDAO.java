package ru.xorsiphus.dao;

import ru.xorsiphus.entity.Books;

import java.util.List;
import java.util.Optional;

public interface IBookDAO
{
    List<Books> findAll();
    List<Books> findByAuthor(String author);
    Optional<Books> findById(int id);
    void updateById(int id, Books books);
    void add(Books books);
    void removeById(int id);
}
