package ru.netology.ProductManager.service;

public class ProductManager {
    private ProductRepository goodsRepo;

    public ProductManager(ProductRepository goodsRepo) {
        this.goodsRepo = goodsRepo;
    }

    public void add(Product good) {
        goodsRepo.saveProduct(good);
    }

    public boolean matches(Product good, String text) {
        if (good.getName().contains(text)) return true;
        else {
            return false;
        }
    }

    public Product[] searchBy(String text) {

        Product[] result = new Product[0];
        for (Product good : goodsRepo.getGoods()) {
            if (matches(good, text)) {
                Product[] tmpResult = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmpResult[i] = result[i];
                }
                tmpResult[tmpResult.length - 1] = good;
                result = tmpResult;
            }
        }
        return result;
    }
}