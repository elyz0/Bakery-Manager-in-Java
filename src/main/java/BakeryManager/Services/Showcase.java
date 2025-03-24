package BakeryManager.services;

import java.util.HashMap;
import java.util.Map;

import BakeryManager.model.Product;

public class Showcase {
    private Map<String, Product> showcase = new HashMap<>();
     
    //Método para adicionar os Products à vitrine 
    public void addToShowcase(Map <String, Product> items, String itemName ){ 
        Product products = items.get(itemName);  
         
        if(products != null && products.getQuantity() > 0){ 
            showcase.put(itemName, products);
            System.out.println(products.getName() + " foi adicionado à vitrine.");
        }  
        else {
            System.out.println("Item não encontrado ou sem estoque: " + itemName);
        }
    } 
     
    public void displayShowcase(){ 
        System.out.println("Vitrine do dia:");
        for (Product product : showcase.values()) {
            System.out.println(product);
        }
    }
}
