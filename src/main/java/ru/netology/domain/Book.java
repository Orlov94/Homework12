package ru.netology.domain;

public class Book extends Product {

    private String author;


    public Book(int BookId, String BookName, int BookCost, String author) {
        super.id = BookId;
        super.name = BookName;
        super.cost = BookCost;
        this.author = author;

    }
}