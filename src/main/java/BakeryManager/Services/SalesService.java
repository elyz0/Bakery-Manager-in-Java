package BakeryManager.services;
 
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional; 
 
@Service
public class SalesService {
    private Map<String, Integer> productSales = new HashMap<>(); //Rastreia vendas por produto
    private Map<String, Integer> dailySales = new HashMap<>(); //Rastreia vendas por dia  
    private final InventoryManager inventoryManager; //Dependência para gerenciar estoque
       
    public SalesService(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    } 
     
    @Transactional
    //Método para registrar uma venda
    public void registerSales(String productName, int quantity, String date){  
         
        if (quantity <= 0) { 
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
      
        //Validação da quantidade
        int availableQuantity = inventoryManager.checkInventory(productName);
        if (availableQuantity < quantity) {
            throw new IllegalStateException("Estoque insuficiente para o produto: " + productName + 
                                          ". Disponível: " + availableQuantity);
        } 

        // Atualiza vendas por produto
        productSales.merge(productName, quantity, Integer::sum); 

         // Atualiza vendas por dia
        dailySales.merge(date, quantity, Integer::sum); //Usando merge que é uma operação atômica do Map
        
        // Atualiza estoque
        inventoryManager.removeItem(productName, quantity);
    }  
  
    //Atualiza o estoque removendo os itens vendidos
    public Map<String, Integer> getProductSales() {
        return new HashMap<>(productSales); // Retorna cópia para evitar modificações externas
    }

    public Map<String, Integer> getDailySales() {
        return new HashMap<>(dailySales); // Retorna cópia para evitar modificações externas
    }

    public String getBestSellingProduct() {
        return getKeyWithHighestValue(productSales, "Nenhum produto vendido ainda");
    }
 
    //Identifica o produto mais vendido.
    public String getBestSalesDay() {
        return getKeyWithHighestValue(dailySales, "Nenhuma venda registrada ainda");
    }
 
    //Método para obter o dia com mais vendas
    public String getKeyWithHighestValue(Map<String, Integer> map, String defaultValue){ 
        
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(defaultValue);
    }
        
}
