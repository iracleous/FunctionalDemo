package gr.codehub;

import gr.codehub.model.Product;
import gr.codehub.repository.ProductRepository;

public class MainApp {

    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepository();

        { Product product = new Product("chips", 1.2);
        productRepository.addProduct(product);}
        {Product product = new Product("chocolates", 1.3);
        productRepository.addProduct(product);}
        { Product product = new Product("chicklets", 1.0);
        productRepository.addProduct(product);}
        {Product product = new Product("wafer", 0.8);
        productRepository.addProduct(product);}

        productRepository.listProducts();

        System.out.println("-----------------------------");
        productRepository.sortByPrice();
        productRepository.listProducts();

        System.out.println("-----------------------------");
        productRepository.sortByName();
        productRepository.listProducts();


        System.out.println("-----------------------------");
        System.out.println("Total cost = " + productRepository.totalPrice());


        System.out.println("-----------------------------");
        System.out.println("Minimum price = " + productRepository.min() + " "+ productRepository.minPriceProduct());


        System.out.println("------------Increase 10%--------");
        productRepository.increasePrice(0.1);
        productRepository.listProducts();


    }
}
