package com.example.Team25SpringMongoRest.service;

import com.example.Team25SpringMongoRest.model.BookDetails.Author;
import com.example.Team25SpringMongoRest.repository.AuthorRepository;
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
