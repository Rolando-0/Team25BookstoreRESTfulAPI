package com.example.SpringMongoREST.services;

import com.example.SpringMongoREST.Author.Author;
import com.example.SpringMongoREST.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
}
