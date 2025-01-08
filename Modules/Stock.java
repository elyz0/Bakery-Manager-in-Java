package Modules;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<String, Items> items = new HashMap<>(); /* HashMap não garante a ordem das chaves mas tem melhor desempenho */
    private Map<String, Map<String, Integer>> recipes = new HashMap<>(); // Armazena as receitas  
     
    /*  public void addItem(String itemName, int quantity) {
            items.put(item, items.getOrDefault(item, 0) + quantity); 
        };  
    Trabalha apenas com o nome e a quantidade do item, que são representados como String e Integer. Não há encapsulamento nem espaço para adicionar mais propriedades ao item no futuro (validade, descrição, categoria etc...).
    */ 
       
    //Método para adicionar itens (ingredientes e produtos) ao estoque  
    public void addItem(String itemName, int quantity) {
        Items item = items.getOrDefault(itemName, new Items(itemName, 0)); //método da interface Map que retorna o valor associado a uma chave específica. Se a chave não existir no mapa, retorna um valor padrão fornecido como argumento.
        item.addQuantity(quantity);
        items.put(itemName, item); //atualiza o mapa como o objeto Item
    }
    
    /*public void removeItem(String item, int quantity) {
        if (items.containsKey(item) && items.get(item) >= quantity) {
            items.put(item, items.get(item) - quantity);
        } else {
            System.out.println("Estoque insuficiente ou item inexistente: " + item);
        }
    }*/ 
     
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
    public int checkStock(String itemName) { 
        Items item = items.get(itemName); //Get busca o objeto associado ao nome
        return item != null ? item.getQuantity() : 0; //Se diferente de null (encontrado) então retorna a qntd, se não, retorna 0.
    } 
      
    //Método para armazenar a receita de um produto, ela utiliza os ingredientes do estoque
    public void addRecipe(Map<String, Integer> ingredients, String productName) {
        recipes.put(productName, ingredients);
    } 
     
    // Método para obter uma receita
    public Map<String, Integer> getRecipe(String recipeName) {
        return recipes.getOrDefault(recipeName, null);
    }
       
}
