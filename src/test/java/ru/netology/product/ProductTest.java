package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product first = new Book(111, "Чапаев и Пустота", 700, "Пелевин");
    Product second = new Smartphone(222, "Mi Mix2", 22000, "Xiaomi");
    Product third = new Book(333, "Fight Club", 600, "Palahnuik");
    Product fourth = new Smartphone(444, "Iphone 10", 56660, "Apple");


    @Test
    void shouldFindAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddProduct() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);


        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, fourth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById1() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        repository.removeById(222);

        Product[] actual = repository.findAll();
        Product[] expected = {first, third, fourth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById2() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        repository.removeById(222);
        repository.removeById(333);

        Product[] actual = repository.findAll();
        Product[] expected = {first, fourth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdAll() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        repository.removeById(222);
        repository.removeById(333);
        repository.removeById(111);
        repository.removeById(444);

        Product[] actual = repository.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearch2ByQuery() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] actual = manager.searchBy("i");

        Product[] expected = {second, third};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearch0ByQuery() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] actual = manager.searchBy("Z");

        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAllByQuery() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] actual = manager.searchBy(" ");

        Product[] expected = {first, second, third, fourth};

        Assertions.assertArrayEquals(expected, actual);
    }

}

