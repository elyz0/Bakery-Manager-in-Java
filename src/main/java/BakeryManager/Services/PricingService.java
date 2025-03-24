package BakeryManager.services;
  
import BakeryManager.model.Items;

import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service; 

import java.util.HashMap;
import java.util.Map;
 
@Service
public class PricingService { 

    RecipeManager recipeManager;  
    InventoryManager inventory; 

    public PricingService(RecipeManager recipeManager, InventoryManager inventory) {
        this.recipeManager = recipeManager;  //this diferencia variáveis locais (definidas dentro de um método) e campos da classe (variáveis de instância), usado para mostra que está acessando um campo da classe
        this.inventory = inventory;
    } 
 
     //Método para obter o preço do ingrediente 
    public double getPrice(String ingredientName) {  

        Items item = inventory.getItem(ingredientName); 

        if (item != null) {
            return item.getPrice();  // Já podemos acessar getPrice() diretamente porque está na classe base (Items)
        } else {
            return 0.0;  // Se o item não existir, retorna 0.0
        } 

    }  

    public double calculateProductPrice(String productName, double profitMargin){  
         
        /* Problemas da antiga forma: O serviço estava acoplado a interações de console, o gerenciamento manual da criação de receitas e o uso de valor especial (-1) para indicar erro.
        if (recipeManager.getRecipe(productName) == null) { //Esse if é para caso não exista receita então o hasRecipe retorna false e o ! inverte para true e o if é executado
            System.out.println("A receita para o produto '" + productName + "' não foi encontrada. Deseja adicionar a receita para o produto '" + productName + "'? (s/n): ");
            if(resposta.equals("s")){  
                Map<String, Integer> ingredientsForRecipe = new HashMap<>(); 
                recipeManager.addRecipe(ingredientsForRecipe, productName, 0); 
                System.out.println("Receita para o produto '" + productName + "' adicionada com sucesso.");
            }
        }
        else{ 
            System.out.println("Não foi possível calcular o preço sem a receita.");
            return -1;  // Retorna um valor indicando erro
        }*/
           
        //Verifica se a receita já existe  
        if (!recipeManager.hasRecipe(productName)) {
            throw new IllegalArgumentException("Receita para o produto '" + productName + "' não encontrada"); //APIs REST normalmente usam códigos HTTP para comunicação de estados e a exceção será convertida em uma resposta HTTP adequada (ex: 404 Not Found)
        }

        //Obtem a receita
        Map<String, Integer> recipe = recipeManager.getRecipe(productName);
        double totalCost = 0; 
         
        //Calcula o custo total dos ingredientes 
        for(Map.Entry<String, Integer> entry : recipe.entrySet()) { // Map é a interface, Entry é uma interface interna e o ponto é usado para acessar os membros de uma classe ou interface. entry é uma variável temporária que representa cada chave-valor do mapa durante a iteração. Os : são usados no loop for-each para iterar sobre elementos de uma coleção, for (Tipo elemento : coleção) { Tipo: O tipo dos elementos contidos na coleção. Elemento: Uma variável temporária que representa cada elemento da coleção durante a iteração.coleção: A coleção (ou array) que você está percorrendo. Pode ser uma lista, um conjunto, um mapa, etc.
            String ingredientName = entry.getKey(); //Nome do ingrediente  
            int quantity = entry.getValue(); //Quantidade do ingrediente 
             
            double price = getPrice(ingredientName); //Obtem o preço do ingrediente

            double ingredientCost = price * quantity;
            totalCost += ingredientCost; // Adiciona o custo do ingrediente ao custo total
        } 
         
        return totalCost;
    }
         
}  
