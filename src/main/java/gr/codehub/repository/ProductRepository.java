package gr.codehub.repository;


import gr.codehub.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository {

    private final List<Product> products;


    public  ProductRepository(){
        products = new ArrayList<>();
    }

    public List<Product> getProducts(){
        return products;
    }



    public void addProduct(Product product){
        products.add(product);
    }

    public void listProducts(){

//        for (int i=0;i<products.size();i++){
//            System.out.println(products.get(i).getName() +  "   " + products.get(i).getPrice());
//        }
//
//        for(Product product:products){
//            System.out.println(product.getName() +  "   " + product.getPrice());
//        }
//
//        products.forEach(product -> System.out.println(product.getName() +  "   " + product.getPrice()));
//
//        products.forEach(product-> System.out.println(product));

        products.forEach(System.out::println);

    }

    public void sortByPrice(){

        products.sort( (a,b)-> Double.compare(b.getPrice(),a.getPrice()));
    }

    public void sortByName(){
        products.sort( (a,b)-> a.getName().compareTo(b.getName()));
    }


    public double totalPrice(){
        return products
                .stream()
                .map(Product::getPrice)
                .reduce(0.0, (a,b)->a+b);
    }

    public double min(){
        return products.stream()
                .map(product -> product.getPrice())
                .mapToDouble(Double::doubleValue)
                .min()
                .getAsDouble();
    }

    public Product minPriceProduct(){
        return products.stream()
                .min(Comparator.comparingDouble(Product::getPrice))
                .get();
    }


    public void increasePrice(double rate){
        products.forEach(product -> product.setPrice(product.getPrice()*(1+rate)));
    }


    public double averagePrice(){
        return products.stream()
                .map(product -> product.getPrice())
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();
    }

}
