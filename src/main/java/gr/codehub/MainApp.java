package gr.codehub;

import gr.codehub.model.Product;
import gr.codehub.repository.ProductRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {
        int option = 1;
        while(option != 0){
            System.out.println("Option 1|  Option 2| Option 3| Option 0 (Exit) ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            try {
                  option = Integer.parseInt(userInput);
            }
            catch(Exception e){
                option = 1;
            }
            switch(option){
                case 1: function1();
                break;
                case 2: function2();
                break;
                case 3: function3();
                    break;
                case 0:
                    System.out.println("Terminating");
                    break;
                default:
                    System.out.println("Incorrect option");
            }
          }
       }

     public static void function1(){
        System.out.println("Function 1");
    }

    public static void function2(){
        System.out.println("Function 2");
    }

    public static void function3(){
        System.out.println("Function 3");
    }
    public static void testing(){
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



        List<Product> products = productRepository.getProducts();

        List<Product> proposedList = products
                .stream()
                .sorted( (a,b)-> Double.compare(b.getPrice(),a.getPrice()))
                .collect(Collectors.toList());
        System.out.println("-----------------------------");
        proposedList.forEach(System.out::println);


        List<Product> proposedListIncreasedValues = products
                .stream()
                .map(product -> new Product(product.getName(), product.getPrice()*1.2))
                .collect(Collectors.toList());
        System.out.println("-----------------------------");
        proposedListIncreasedValues.forEach(System.out::println);

        List<Product> productsAbove2 = products
                .stream()
                .filter(product -> product.getPrice()>=2)
                .collect(Collectors.toList());
        System.out.println("-----------------------------");
        productsAbove2.forEach(System.out::println);


        List<String> productNames = products
                .stream()
                .map( product -> product.getName())
                .collect(Collectors.toList());

        System.out.println("-----------------------------");
        productNames.stream().limit(2).collect(Collectors.toList()).forEach(System.out::println);
    }


}
