package BakeryManager.services;
 
import BakeryManager.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Showcase {
    private Map<String, Product> showcase = new HashMap<>();
     
    //Método para adicionar os Products à vitrine (retorna mensagem de sucesso/erro)
    public String addToShowcase(Product products){ 
         
        if(products != null && products.getQuantity() > 0){ 
            showcase.put(products.getName(), products);
            return products.getName() + " foi adicionado à vitrine.";
        }  
        else {
            return "Produto inválido ou sem estoque: " + (products != null ? products.getName() : "null");
        }
    } 
     
    //Método para exibir a vitrine
    public Map<String, Product> displayShowcase() {
        return new HashMap<>(showcase); //Retorna uma cópia para evitar modificações externas
    }

    //Método para limpar a vitrine
    public void clearShowcase() {
        showcase.clear();
    } 
      
    // Remove um produto específico da vitrine
    public String removeFromShowcase(String productName) {
        if (showcase.containsKey(productName)) {
            showcase.remove(productName);
            return productName + " removido da vitrine.";
        } else {
            return "Produto não encontrado: " + productName;
        }
    }
}
