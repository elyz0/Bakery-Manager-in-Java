package Modules;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<String, Integer> items = new HashMap<>(); /* HashMap não garante a ordem das chaves mas tem melhor desempenho */
    private Map<String, Map<String, Integer>> recipes = new HashMap<>(); // Armazena as receitas  
     
    //Método para adicionar itens (ingredientes e produtos) ao estoque
    public void addItem(String item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity); /*método da interface Map que retorna o valor associado a uma chave específica. Se a chave não existir no mapa, retorna um valor padrão fornecido como argumento. */
    }; 
      
    //Método para remover itens do estoque
    public void removeItem(String item, int quantity) {
        if (items.containsKey(item) && items.get(item) >= quantity) {
            items.put(item, items.get(item) - quantity);
        } else {
            System.out.println("Estoque insuficiente ou item inexistente: " + item);
        }
    }
      
    //Método para verificar a quantidade em estoque de um item
    public int checkStock(String item) {
        return items.getOrDefault(item, 0);
    } 
      
    //Método para armazenar a receita de um produto, ela utiliza os ingredientes do estoque
    public void addRecipe(Map<String, Integer> ingredients, String product) {
        recipes.put(product, ingredients);
    } 
     
    // Método para obter uma receita
    public Map<String, Integer> getRecipe(String recipeName) {
        return recipes.getOrDefault(recipeName, null);
    }
       
}
