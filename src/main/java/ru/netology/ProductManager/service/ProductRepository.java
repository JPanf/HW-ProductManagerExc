package ru.netology.ProductManager.service;

public class ProductRepository {
    protected Product[] goods = new Product[0];

    public void saveProduct(Product good) {
        Product[] goodsAdded = new Product[goods.length + 1];
        for (int i = 0; i < goods.length; i++) {
            goodsAdded[i] = goods[i];
        }
        goodsAdded[goodsAdded.length - 1] = good;
        goods = goodsAdded;
    }

    public Product[] getGoods() {
        return goods;
    }

    public void removeById(int id) {
        Product[] allGoods = new Product[goods.length - 1];
        int newIndex = 0;
        for (Product good : goods) {
            if (good.getId() != id) {
                allGoods[newIndex] = good;
                newIndex++;
            }
            goods = allGoods;
        }
    }

}



