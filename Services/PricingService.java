package Services;

import java.util.Map;
import java.util.Scanner;
<<<<<<< HEAD
import Model.Recipe; 
=======
>>>>>>> eb9a2181ebc760ce75819cb3e0c7a8d0621240b6

public class PricingService { 

    private RecipeManager recipeManager; 
    private Scanner scanner;

    public PricingService(RecipeManager recipeManager) {
        this.recipeManager = recipeManager;  //this diferencia variáveis locais (definidas dentro de um método) e campos da classe (variáveis de instância), usado para mostra que está acessando um campo da classe
        this.scanner = new Scanner(System.in); //System.in é a entrada padrão do sistema
    } 

    public double calculateProductPrice(String productName, double profitMargin){  
        
        if (!recipeManager.hasRecipe(productName)) { //hasRecipe retorna true se a receita para o produto existe e false se não existir. Esse if é para caso não exista receita então o hasRecipe retorna false e o ! inverte para true e o if é executado
            System.out.println("A receita para o produto '" + productName + "' não foi encontrada. Deseja adicionar a receita para o produto '" + productName + "'? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase(); //nextLine lê a próxima linha digitad apelo usuário, trim remove espaços em branco e toLowerCase converte para minúsculo.
          
            if(resposta.equals("s")){  
<<<<<<< HEAD
                Map<String, Integer> ingredients = coletarIngredientes();
                recipeManager.addRecipe(ingredients, productName, bakingTime); 
=======
                 Map<String, Integer> ingredients = coletarIngredientes();
                recipeManager.addRecipe(ingredients, productName); 
>>>>>>> eb9a2181ebc760ce75819cb3e0c7a8d0621240b6
                System.out.println("Receita para o produto '" + productName + "' adicionada com sucesso.");
            }
        }
        
    }
         
}   
