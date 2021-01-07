package com.library.Domain;

import java.util.Date;

public class BorrowData {
    private int borrow_id;
    private String book_uuid;
    private String user_uuid;
    private Date out_time;
    private String in_time;
    private int book_static;

    private BookData bookData;
    private NormalUser normalUser;


    public Date getOut_time() {
        return out_time;
    }

    public void setOut_time(Date out_time) {
        this.out_time = out_time;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public BookData getBookData() {
        return bookData;
    }

    public void setBookData(BookData bookData) {
        this.bookData = bookData;
    }

    public NormalUser getNormalUser() {
        return normalUser;
    }

    public void setNormalUser(NormalUser normalUser) {
        this.normalUser = normalUser;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public String getBook_uuid() {
        return book_uuid;
    }

    public void setBook_uuid(String book_uuid) {
        this.book_uuid = book_uuid;
    }

    public String getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public int getBook_static() {
        return book_static;
    }

    public void setBook_static(int book_static) {
        this.book_static = book_static;
    }

    @Override
    public String toString() {
        return "BorrowData{" +
                "borrow_id=" + borrow_id +
                ", book_uuid='" + book_uuid + '\'' +
                ", user_uuid='" + user_uuid + '\'' +
                ", out_time=" + out_time +
                ", in_time=" + in_time +
                ", book_static=" + book_static +
                ", bookData=" + bookData +
                ", normalUser=" + normalUser +
                '}';
    }
}
