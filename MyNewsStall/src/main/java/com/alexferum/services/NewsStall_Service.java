package com.alexferum.services;

import com.alexferum.model.Magazine;
import com.alexferum.model.Book;
import com.alexferum.model.NewsStall;
import com.alexferum.model.Newspaper;
import com.alexferum.model.Product;

import java.util.*;

public class NewsStall_Service {
    public void GetProducts(NewsStall newsStall, Product add, int count) {
        newsStall.getProducts().put(add, count);
    }

    public void BuyProduct(NewsStall newsStall, String name, int count) {
        for (Map.Entry<Product, Integer> item : newsStall.getProducts().entrySet()) {
            if (item.getKey().getProductName().equals(name)) {
                if (item.getValue() >= count) {
                    item.setValue(item.getValue() - count);
                    System.out.println("\r\nSuccessful purchase!");
                    return;
                }
                else {
                    System.out.println("\r\nThere is no necessary amount of products!");
                    return;
                }
            }
        }
        System.out.println("\r\nThere is no such product");
    }

    public static Map<Product, Integer> CreateProduct() {
        Random rnd = new Random();

        Book b1 = new Book("Martian", 951, "Crown Publishing", "Andy Weir");
        Newspaper n1 = new Newspaper("New York Times", 157, "MAY2019");
        Magazine m1 = new Magazine("Marca", 263, "JUNE2019");

        Dictionary<Product, Integer> a = new Hashtable<Product, Integer>();
        Map<Product, Integer> g = new HashMap<Product, Integer>();

        g.put(b1, rnd.nextInt(15) + 1);
        g.put(n1, rnd.nextInt(15) + 1);
        g.put(m1, rnd.nextInt(15) + 1);

        return g;
    }

    public void ShowProduct(NewsStall newsStall) {
        newsStall.getProducts().forEach((k, v) -> System.out.println("\r\nProduct name: " + k.getProductName() + "\nProduct quantity: " + v.toString()));
    }

    public void Change(NewsStall newsStall, int count, String name) {
        for (Map.Entry<Product, Integer> item : newsStall.getProducts().entrySet()) {
            if (item.getKey().getProductName().equals(name)) {
                item.setValue(count);
                System.out.println("\r\nSuccessfully edited");
                return;
            }
        }
        System.out.println("\r\nProduct not found!");
    }
}
