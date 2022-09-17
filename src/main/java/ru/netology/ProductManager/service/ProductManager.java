package ru.netology.ProductManager.service;

public class ProductManager {
    protected ProductRepository goodsRepo;

    public ProductManager(ProductRepository goodsRepo) {
        this.goodsRepo = goodsRepo;
    }

    public void add(Product good) {
        goodsRepo.saveProduct(good);
    }

    private boolean matches(Product good, String textSearch) {
        if (good.getName().contains(textSearch)) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchBy(String textSearch) {

        Product[] result = new Product[0];
        for (Product product : goodsRepo.getGoods()) {
            if (matches(product, textSearch)) {
                Product[] tmpResult = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmpResult[i] = result[i];
                }
                tmpResult[tmpResult.length - 1] = product;
                result = tmpResult;
            }
        }
        return result;
    }
}