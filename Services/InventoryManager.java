package Services;

import java.util.HashMap;
import java.util.Map;

import Model.Items;

public class InventoryManager {
    static Map<String, Items> items = new HashMap<>(); /* HashMap não garante a ordem das chaves mas tem melhor desempenho */
    private Map<String, Map<String, Integer>> recipes = new HashMap<>(); // Armazena as receitas  
    
    //Método para adicionar itens (ingredientes e produtos) ao estoque  
    public void addItem(String itemName, int quantity) { 

        Items item = items.getOrDefault(itemName, new Items(itemName, 0, 0)); //método da interface Map que retorna o valor associado a uma chave específica. Se a chave não existir no mapa, retorna um valor padrão fornecido como argumento.
        item.addQuantity(quantity);
        items.put(itemName, item); //atualiza o mapa como o objeto Item 

    }
    
    //Método para remover itens do estoquec
    public void removeItem(String itemName, int quantity) { 

        Items item = items.get(itemName); 

        if (item != null && item.removeQuantity(quantity)) {
            items.put(itemName, item);
        } else {
            System.out.println("Estoque insuficiente ou item inexistente: " + itemName);
        } 

    }

    //Método para verificar a quantidade em estoque de um item
    public int checkInventory(  String itemName) {  

        Items item = items.get(itemName); //Get busca o objeto associado ao nome
        return item != null ? item.getQuantity() : 0; //Se diferente de null (encontrado) então retorna a qntd, se não, retorna 0. 

    } 
      
    public Items getItem(String ingredientName) {
        return items.get(ingredientName); // get é um  método de map, Retorna o item ou null se não existir
    }
}
