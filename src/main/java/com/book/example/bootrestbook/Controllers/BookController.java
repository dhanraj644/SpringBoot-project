package com.book.example.bootrestbook.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.book.example.bootrestbook.entities.Book;
import com.book.example.bootrestbook.services.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getBook()
    {        
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBooks(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
    
        Book b=this.bookService.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{bookid}")
    public void deleteBook(@PathVariable("bookid") int id)
    {
        this.bookService.deleteBook(id);
    }
    
    @PutMapping("/books/{bookid}")
    public Book updateBook( @RequestBody Book book,@PathVariable("bookid") int id)
    {
        this.bookService.updateBook(book,id);
        return book;
    }
}
