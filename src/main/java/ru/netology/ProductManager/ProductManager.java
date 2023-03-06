package ru.netology.ProductManager;

import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.ProductRepository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }
//    public Product[] findAll() {
//        return repo.findAll();
//    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (product.matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];     //временный массив
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];                             //копируем массив

                }
                tmp[tmp.length - 1] = product;                      //добавляем
                result = tmp;

                // "добавляем в конец" массива result продукт product
            }

        }
        return result;
    }

}


