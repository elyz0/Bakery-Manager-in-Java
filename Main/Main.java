package Main;
import java.util.HashMap;
import java.util.Map;

import Model.Product;
import Services.Stock;

public class Main{ 
    public static void main(){ //Quando executado o JVM procura por um método com exatamente esta assinatura
        System.out.println("hello world"); 
         
           Stock stock = new Stock();
        stock.addItem("Farinha", 5);
        stock.addItem("Ovo", 10);
        stock.addItem("Açúcar", 3);

        // Criando uma receita para um bolo
        Map<String, Integer> cakeRecipe = new HashMap<>();
        cakeRecipe.put("Farinha", 2);
        cakeRecipe.put("Ovo", 3);
        cakeRecipe.put("Açúcar", 1);

        // Adicionando a receita ao estoque
        stock.addRecipe(cakeRecipe, "Bolo", 0); 
 
        Map<String, Product> items = new HashMap<>();
        items.put("Bolo de Chocolate", new Product("Bolo de Chocolate", 25, 10));
        items.put("Pastel de Nata", new Product("Pastel de Nata", 5, 5));
    }
}