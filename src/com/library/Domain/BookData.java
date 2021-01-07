package com.library.Domain;

public class BookData {
    private String book_uuid;
    private String book_name;
    private String book_author;
    private String book_isbn;
    private String book_price;
    private String book_remarks;
    private int book_static;
    private int book_remsining;

    public String getBook_uuid() {
        return book_uuid;
    }

    public void setBook_uuid(String book_uuid) {
        this.book_uuid = book_uuid;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    public String getBook_remarks() {
        return book_remarks;
    }

    public void setBook_remarks(String book_remarks) {
        this.book_remarks = book_remarks;
    }

    public int getBook_static() {
        return book_static;
    }

    public void setBook_static(int book_static) {
        this.book_static = book_static;
    }

    public int getBook_remsining() {
        return book_remsining;
    }

    public void setBook_remsining(int book_remsining) {
        this.book_remsining = book_remsining;
    }
}
