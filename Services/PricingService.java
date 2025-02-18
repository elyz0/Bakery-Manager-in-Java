package Services;
 
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Classes no mesmo pacote não precisam ser importadas 

public class PricingService { 

    RecipeManager recipeManager;  
    Stock stock; 
    private Scanner scanner;

    public PricingService(RecipeManager recipeManager, Stock stock, Scanner scanner) {
        this.recipeManager = recipeManager;  //this diferencia variáveis locais (definidas dentro de um método) e campos da classe (variáveis de instância), usado para mostra que está acessando um campo da classe
        this.scanner = scanner; //System.in é a entrada padrão do sistema  
        this.stock = stock;
    } 

    public double calculateProductPrice(String productName, double profitMargin){  
         
        //Verifica se a receita já existe
        if (recipeManager.getRecipe(productName) == null) { //Esse if é para caso não exista receita então o hasRecipe retorna false e o ! inverte para true e o if é executado
            System.out.println("A receita para o produto '" + productName + "' não foi encontrada. Deseja adicionar a receita para o produto '" + productName + "'? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase(); //nextLine lê a próxima linha digitad apelo usuário, trim remove espaços em branco e toLowerCase converte para minúsculo.
          
            if(resposta.equals("s")){  
                Map<String, Integer> ingredientsForRecipe = new HashMap<>(); 
                recipeManager.addRecipe(ingredientsForRecipe, productName, 0); 
                System.out.println("Receita para o produto '" + productName + "' adicionada com sucesso.");
            }
        }
        else{ 
            System.out.println("Não foi possível calcular o preço sem a receita.");
            return -1;  // Retorna um valor indicando erro
        } 
          
        //Obtem a receita
        Map<String, Integer> recipe = recipeManager.getRecipe(productName);
        double totalCost = 0; 
         
        //Calcula o custo total dos ingredientes 
        for(Map.Entry<String, Integer> entry : recipe.entrySet()) { // Map é a interface, Entry é uma interface interna e o ponto é usado para acessar os membros de uma classe ou interface. entry é uma variável temporária que representa cada chave-valor do mapa durante a iteração. Os : são usados no loop for-each para iterar sobre elementos de uma coleção, for (Tipo elemento : coleção) { Tipo: O tipo dos elementos contidos na coleção. Elemento: Uma variável temporária que representa cada elemento da coleção durante a iteração.coleção: A coleção (ou array) que você está percorrendo. Pode ser uma lista, um conjunto, um mapa, etc.
            String ingredientName = entry.getKey(); //Nome do ingrediente  
            int quantity = entry.getValue(); //Quantidade do ingrediente 
             
            double price = stock.getPrice(ingredientName); 

            double ingredientCost = price * quantity;
            totalCost += ingredientCost; // Adiciona o custo do ingrediente ao custo total
        } 
         
        return totalCost;
    }
         
}  
