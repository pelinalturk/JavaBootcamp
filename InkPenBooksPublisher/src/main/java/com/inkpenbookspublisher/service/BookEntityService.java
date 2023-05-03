package com.inkpenbookspublisher.service;


import com.inkpenbookspublisher.model.Book;

import java.util.List;

public interface BookEntityService {
    Book save(Book book);
    List<Book>findAll();
}
