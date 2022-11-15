package com.gotbizlogic.demo.of.incompleteCodeBase.services;

import com.gotbizlogic.demo.of.incompleteCodeBase.models.Author;
import com.gotbizlogic.demo.of.incompleteCodeBase.models.Book;
import com.gotbizlogic.demo.of.incompleteCodeBase.repos.AuthorRepo;
import com.gotbizlogic.demo.of.incompleteCodeBase.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class BookService {

        /*
            //THIS IS THE ONLY FILE YOU SHOULD WRITE CODE
            //THIS IS WHERE YOUR LOGIC COMES INTO PLAY
            //DO NOT TOUCH THE CONTROLLER OR MODELS OR REPOS!!!
        */
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private AuthorRepo authorRepo;

    //Todo - Business Logic or Algorithm needed to create a book
    public Book createBook( Long authorId,Book bookRequest) {
        authorRepo.findById(authorId).map(author -> {
            bookRequest.setAuthor(author);
            return bookRepo.save(bookRequest);
        });
        return bookRequest;
    }

    //Todo - Business Logic or Algorithm needed to getAllBooksByAuthorId
    public Iterable<Book>getAllBooksByAuthorId(Long authorId){
       return bookRepo.findByAuthorId(authorId);
    }
    //Todo - Business Logic or Algorithm needed to getBookById
    public Optional<Book> getBookById(Long id){
        return bookRepo.findById(id);

    }
}
