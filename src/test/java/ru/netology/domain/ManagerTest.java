package ru.netology.domain;

import org.junit.jupiter.api.Test;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryManagerTest {


    ProductManager manager = new ProductManager();


    Book book1 = new Book(101, "brave new world", 500, "aldous leonard huxley");
    Book book2 = new Book(102, "three comrades,", 450, "remarque erich maria");
    Book book3 = new Book(103, "harry potter and the deathly hallows,", 900, "joanne rowling");
    Book book4 = new Book(104, "atlas shrugged,", 1200, "jayn rand");

    Smartphone smartphone1 = new Smartphone(201, "new iphone", 70000, "usa");
    Smartphone smartphone2 = new Smartphone(202, "samsung", 60000, "south korea");
    Smartphone smartphone3 = new Smartphone(203, "honor", 40000, "china");
    Smartphone smartphone4 = new Smartphone(204, "huawei", 35000, "china");


    @Test
    void shouldFindAll() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4};

        assertArrayEquals(actual, expected);

    }

    @Test
    void shouldFindBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, book4};

        assertArrayEquals(actual, expected);

    }

    @Test
    void shouldFindSmartphone() {

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.findAll();
        Product[] expected = {smartphone1, smartphone2, smartphone3, smartphone4};

        assertArrayEquals(actual, expected);

    }

    @Test
    void shouldSearchByThreeLetters() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("new");
        Product[] expected = {book1, smartphone1};

        assertArrayEquals(actual, expected);


    }

    @Test
    void shouldDeleteId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        manager.removeId(102);
        manager.removeId(104);
        manager.removeId(201);
        manager.removeId(203);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book3, smartphone2, smartphone4};

        assertArrayEquals(actual, expected);


    }

    @Test
    void shouldDeleteIdNotFind() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);


        manager.removeId(205);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4};

        assertArrayEquals(actual, expected);


    }

}