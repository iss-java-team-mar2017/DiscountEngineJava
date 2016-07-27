package iss.pos.test;

import iss.pos.Product;

import java.util.HashMap;

public class Products {
    static HashMap<String,Product> products = new HashMap<String, Product>(); 

    static 
    {
        products.put("redDress",    new Product("1001.1", "Red Dress",   100.0));
        products.put("greenDress",  new Product("1001.2", "Green Dress", 100.0));
        products.put("blueDress",   new Product("1001.3", "Blue Dress",  100.0));
        products.put("whiteSocks",  new Product("2001.1", "White Socks", 10.0));
        products.put("redSocks",    new Product("2001.2", "Red Socks",   10.0));
    }

    public static Product GetProduct(String name)
    {
        return products.get(name);
    }

}
