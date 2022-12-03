package com.example.library.studentlibrary.services;

import com.example.library.studentlibrary.models.Book;
import com.example.library.studentlibrary.models.Genre;
import com.example.library.studentlibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

    public void createBook(Book book){
       book.setAuthor(book.getAuthor());
        book.setAvailable(true);
        bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books=new ArrayList<>();
        if(genre!=null && available==true){
            books=bookRepository2.findBooksByGenre(genre,true);
            books=bookRepository2.findBooksByAuthor(author,true);
            books=bookRepository2.findBooksByGenreAuthor(genre,null,true);
        }else if(genre!=null && author!=null && available==false){
            books=bookRepository2.findBooksByGenre(genre,false);
            books=bookRepository2.findBooksByAuthor(author,false);
            books=bookRepository2.findByAvailability(false);
        }
        //List<Book> books = null; //find the elements of the list by yourself
        return books;
    }
}