package ru.netology.domain.ru.netology.repository;

import ru.netology.domain.Product;

public class RepositoryManager {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product newProduct) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newProduct;
        products = tmp;
    }


    public void removeId(int removeById) {

        Product[] tmp = new Product[products.length - 1];
        int copy = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() != removeById) {
                if (copy + 1 == products.length) {
                    return;
                }
                tmp[copy] = products[i];
                copy++;
            }

        }
        products = tmp;
    }

}


//        int length = products.length - 1;
//        Product[] tmp = new Product[length];
//        int index = 0;
//        for (Product product : products) {
//            if (product.getId() != removeById) {
//                if (index + 1 == products.length)
//                    return;
//            }
//                tmp[index] = product;
//                index++;
//            }
//        products = tmp;
