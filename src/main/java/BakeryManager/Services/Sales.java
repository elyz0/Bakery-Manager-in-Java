package BakeryManager.services;
 
import java.util.HashMap;
import java.util.Map; 

public class Sales {
    private Map<String, Integer> productSales = new HashMap<>(); //Rastreia vendas por produto
    private Map<String, Integer> dailySales = new HashMap<>(); //Rastreia vendas por dia 
      
    //Método para registrar uma venda
    public void registerSales(String productName, int quantity, String date, InventoryManager inventory){  
         
        if (inventory.checkInventory(productName) < quantity) {
            System.out.println("Estoque insuficiente para o produto: " + productName);
            return;
        }
    
        //Atualiza as vendas por produto. Busca o productName em productSales, retorna o valor associado ao produto e soma a quantity, depois put atualiza (quantidade vendida daquele produto).
        productSales.put(productName, productSales.getOrDefault(productName, 0) + quantity);
        //Atualiza as vendas por dia
        dailySales.put(date, dailySales.getOrDefault(date, 0) + quantity); 
        // Atualiza o estoque
        inventory.removeItem(productName, quantity);
    }  

    //Método para obter o produto mais vendido e o dia com mais vendas
    public String getKeyWithHighestValue(Map<String, Integer> map, String defaultValue){ 
        String highestKey = defaultValue;
        int highestValue = 0;
         
        if (map == null || map.isEmpty()) {
            return defaultValue; // Retorna valor padrão se o mapa for nulo ou vazio
        } 

        for (Map.Entry<String, Integer> entry : map.entrySet()) { // entrySet são todas as entradas do mapa
            if (entry.getValue() > highestValue) { 
                highestValue = entry.getValue();
                highestKey = entry.getKey();
            }
        }
        
        return highestKey;
    }
        
}
