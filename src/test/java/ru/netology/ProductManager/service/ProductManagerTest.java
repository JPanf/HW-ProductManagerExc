package ru.netology.ProductManager.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ProductManager.service.*;

public class ProductManagerTest {
    ProductRepository goodsRepo = new ProductRepository();
    ProductManager manager = new ProductManager(goodsRepo);

    Product good1 = new Book(1, "The Lord of the rings", 10_000, "J.R.R. Tolkien");
    Product good2 = new Book(22, "Java without doubt", 500, "F.Voronov");
    Product good3 = new Smartphone(321, "Nokia 3110", 5000, "Nokia, Finland");
    Product good4 = new Product(400, "PC mouse", 500);
    Product good5 = new Smartphone(555, "Superphone", 9_000, "Russia");
    Product good6 = new Smartphone(556, "S-phone", 9_000, "Russia");

    @BeforeEach
    public void setup() {
        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);
        manager.add(good5);
        manager.add(good6);
    }
    @Test
    public void shouldFindAllByName() {
        //String text = "phone";

        Product[] actual = manager.searchBy("phone");
        Product[] expected = {good5, good6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOnlyOne() {
        //String textSearch = "mouse";

        Product[] actual = manager.searchBy("mouse");
        Product[] expected = {good4};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindNothingIfNo() {
        //String textSearch = "shirt";

        Product[] actual = manager.searchBy("shirt");
        Product[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }
}
