package com.library.Service;

import com.library.Domain.BookData;

import java.util.List;

public interface BookDataService {
    List<BookData> findAllBook();

    BookData findBook(String uuid);

    boolean outBook(int id, String uuid);
}
