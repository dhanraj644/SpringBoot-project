package com.book.example.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.book.example.bootrestbook.entities.Book;

@Component
public class BookService {
    
    private static List<Book> list = new ArrayList<>();
    static{
        list.add(new Book(12,"java","abc"));
        list.add(new Book(13,"c","xyz"));
        list.add(new Book(14,"c++","bcd"));
        list.add(new Book(15,"python","ddll"));
    }
    
    //get all books
    public List<Book> getAllBooks()
    {
        return list;
    }

    //get singel book
    public Book getBookById(int id)
    {
        Book book=null;
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    //add Book
    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }

    //deleteBook
    public void deleteBook(int bid)
    {
        list=list.stream().filter(book->book.getId()!=bid).
        collect(Collectors.toList());
    }

    //updatebook
    public void updateBook( Book book , int id)
    {
       list=list.stream().map(b->{
            if(b.getId()==id)
            {
                b.setTitel(book.getTitel());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
