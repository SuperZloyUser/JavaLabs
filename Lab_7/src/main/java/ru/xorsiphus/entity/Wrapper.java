package ru.xorsiphus.entity;

import java.util.List;

public class Wrapper
{
    private List<Book> bookList;

    public Wrapper(List<Book> bookList)
    {
        this.bookList = bookList;
    }

    public List<Book> getBookList()
    {
        return bookList;
    }

    public void setBookList(List<Book> bookList)
    {
        this.bookList = bookList;
    }
}
