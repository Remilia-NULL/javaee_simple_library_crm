package com.library.Service;

import com.library.Domain.BorrowData;

import java.sql.SQLException;
import java.util.List;

public interface BorrowService {
    List<BorrowData> findAllBorrow();

    BorrowData findBorrow(int id);

    boolean addBorrow(BorrowData borrowData);

    boolean editBorrowStatic(int id);

    List<BorrowData> findBorrowByUser(String uuid);
}
