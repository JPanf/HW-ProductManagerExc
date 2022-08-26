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
    public void shouldShowAllAddedGoods() {
        Product[] actual = goodsRepo.getGoods();
        Product[] expected = {good1, good2, good3, good4, good5, good6};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddNewProduct() {
        Product good7 = new Book(7, "Add one more", 250, "V.Dobavkin");
        manager.add(good7);

        Product[] actual = goodsRepo.getGoods();
        Product[] expected = {good1, good2, good3, good4, good5, good6, good7};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveGoodsById() {
        //int id = 400;
        goodsRepo.removeById(400);

        Product[] actual = goodsRepo.getGoods();
        Product[] expected = {good1, good2, good3, good5, good6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName() {
        //String text = "phone";

        Product[] actual = manager.searchBy("phone");
        Product[] expected = {good5, good6};

        Assertions.assertArrayEquals(expected, actual);
    }


}
