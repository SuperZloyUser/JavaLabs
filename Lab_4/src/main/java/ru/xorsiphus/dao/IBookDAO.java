package ru.xorsiphus.dao;

import ru.xorsiphus.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDAO
{
    List<Book> findAll();
    List<Book> findByAuthor(String author);
    Optional<Book> findById(int id);
    void updateById(int id, Book book);
    void add(Book book);
    void removeById(int id);
}
