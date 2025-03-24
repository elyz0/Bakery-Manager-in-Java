package BakeryManager.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Service;
 
/*Gerencia a adição de novas receitas ao sistema, interage com a classe Stock para garantir que os ingredientes usados estejam no estoque. Se um ingrediente não existir, o usuário tem a opção de adicioná-lo.*/
 
@Service
public class RecipeManager{ 
    private InventoryManager inventory;  //Armazena a referência a um objeto de Stock que já foi criado. Só existe um objeto/instância então não precisa especificar 
    private Scanner scanner; //Declarar o Scanner como um atributo permite que ele seja acessado em todos os métodos da classe, sem precisar criar um novo Scanner toda vez. 
    private Map<String, Map<String, Integer>> recipes; 

    /*Esse construtor é útil para que RecipeManager interaja diretamente com stock, sem ele precisaríamos criar um objeto stock, porem surgiria um erro, toda vez que fosse criado um RecipeManager, um novo Stock seria criado. Ou seja, diferentes partes do código estariam acessando estoques diferentes, e os ingredientes não seriam compartilhados corretamente. Logo um construtor é a maneira mais eficiente e segura de garantir que RecipeManager tenha acesso a um Stock já criado.*/
    public RecipeManager(InventoryManager inventory) {  //objetos são passados por referência. Isso significa que, quando você passa um objeto como argumento, você está passando uma referência (um "ponteiro") para o mesmo objeto, e não uma cópia dele.
        this.inventory = inventory; 
        this.scanner = new Scanner(System.in);   
         this.recipes = new HashMap<>();
    } 
    
    //Adiciona uma nova receita ao sistema
    public void addRecipe(Map<String, Integer> ingredientsForRecipe, String recipeName, int bakingTime){ 
           
        if (ingredientsForRecipe == null || ingredientsForRecipe.isEmpty()) {
            System.out.println("A lista de ingredientes está vazia. Não é possível adicionar a receita.");
            return;
        } 

        /*if (getRecipe(recipeName) != null) { //Verifica se a receita já existe no sistema
            System.out.println("A receita já existe no sistema."); 
            return; 
        } Dessa outra forma é mais eficiente e clara*/  
        if (recipes.containsKey(recipeName)) { // Verifica se a receita já existe
            System.out.println("A receita já existe no sistema.");
            return;
        }
  
        //ingredientsForRecipe é um Map<String, Integer>, onde as chaves (String) são os nomes dos ingredientes, e os valores (Integer) são as quantidades necessárias PARA A RECEITA. O outro map ingredients existente é com a quantidade que o ingrediente é comprado.   
        //O método entrySet() retorna um conjunto (Set) de todas as entradas (Map.Entry<K, V>) do mapa. Ou seja, pega todos os pares chave-valor do Map e os transforma em um conjunto de elementos iteráveis.
        for(Map.Entry<String, Integer> entry : ingredientsForRecipe.entrySet()) { //: indica que a variável à esquerda do : receberá, em cada iteração, um elemento da coleção à direita.
            String ingredient = entry.getKey(); //Pega a chave do mapa que é o nome do ingrediente
            int requiredQuantity = entry.getValue(); // Quantidade necessária 

            //Verifica se o ingrediente já existe 
            if(inventory.checkInventory(ingredient) < requiredQuantity){  
                System.out.println("O ingrediente " + ingredient + " não existe no estoque.\n Deseja adicionar ao estoque? (sim/não)"); 
                String answer = scanner.nextLine(); 
                     
                if(answer.equalsIgnoreCase("sim")){ //equalsIgnoreCase comparar duas strings ignorando diferenças entre letras maiúsculas e minúsculas.
                    System.out.println("Quantidade a adicionar:"); 
                    int quantityToAdd = scanner.nextInt();
                    inventory.addItem(ingredient, quantityToAdd); 
                    System.out.println("Adicionado com sucesso.");
                } 
                else{ 
                    System.out.println("Não é possivel adicionar a receita sem o ingrediente"); 
                    return;
                } 
            }  
        }  
        recipes.put(recipeName, ingredientsForRecipe);
        System.out.println("Receita " + recipeName + " adicionada ao sistema com sucesso.");
    }  
     
    // Método para obter uma receita
    public Map<String, Integer> getRecipe(String recipeName) { 
        return recipes.getOrDefault(recipeName, null); 
    }  
     
    // Método para verificar se uma receita existe
    public boolean hasRecipe(String recipeName) {
        return recipes.containsKey(recipeName);
    }
}
