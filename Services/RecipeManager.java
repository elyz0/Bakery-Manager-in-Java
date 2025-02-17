package Services;

import java.util.Map;
import java.util.Scanner;
 

/*Gerencia a adição de novas receitas ao sistema, interage com a classe Stock para garantir que os ingredientes usados estejam no estoque. Se um ingrediente não existir, o usuário tem a opção de adicioná-lo.*/
 
public class RecipeManager extends Stock{ 
    private Stock stock;  //verificar e adicionar ingredientes
    private Scanner scanner; //captura entrada e saida  

    /*Esse construtor é útil para que RecipeManager interaja diretamente com stock, sem ele precisaríamos criar um objeto stock, porem surgiria um erro, toda vez que fosse criado um RecipeManager, um novo Stock seria criado. Ou seja, diferentes partes do código estariam acessando estoques diferentes, e os ingredientes não seriam compartilhados corretamente. Logo um construtor é a maneira mais eficiente e segura de garantir que RecipeManager tenha acesso a um Stock já criado.*/
    public RecipeManager(Stock stock) {  
        this.stock = stock; 
        this.scanner = new Scanner(System.in);  
    } 
     
    public boolean hasRecipe (String RecipeName) { //hasRecipe retorna true se a receita para o produto existe e false se não existir.
        return stock.getRecipe(RecipeName) != null;
    }  

    public void addRecipe(Map<String, Integer> ingredientsForRecipe, String recipeName, int bakingTime){ 
        
        if (hasRecipe(recipeName)) { 
            System.out.println("A receita já existe no sistema."); 
            return; 
        } 
  
        //ingredients é um Map<String, Integer>, onde as chaves (String) são os nomes dos ingredientes, e os valores (Integer) são as quantidades necessárias PARA A RECEITA. O outro map ingredients existente é com a quantidade do ingrediente NO ESTOQUE.   
        //O método entrySet() retorna um conjunto (Set) de todas as entradas (Map.Entry<K, V>) do mapa. Ou seja, pega todos os pares chave-valor do Map e os transforma em um conjunto de elementos iteráveis.
        for(Map.Entry<String, Integer> entry : ingredientsForRecipe.entrySet()) { //: indica que a variável à esquerda do : receberá, em cada iteração, um elemento da coleção à direita.
            String ingredient = entry.getKey(); //Pega a chave do mapa que é o nome do ingrediente
            //Verifica se o ingrediente já existe
            if(stock.checkStock(ingredient) == 0){  
                System.out.println("O ingrediente " + ingredient + " não existe no estoque.\n Deseja adicionar ao estoque? (sim/não)"); 
                String answer = scanner.nextLine(); 
                     
                if(answer.equalsIgnoreCase("sim")){ //equalsIgnoreCase comparar duas strings ignorando diferenças entre letras maiúsculas e minúsculas.
                    stock.addItem(recipeName, 0); 
                    System.out.println("Adicionado com sucesso.");
                } 
                else{ 
                    System.out.println("Não é possivel adicionar a receita sem o ingrediente"); 
                    return;
                } 
            }  
            else{ 
                ;
            } 
        } 
        stock.addRecipe(ingredientsForRecipe, recipeName, bakingTime);
        System.out.println("Receita " + recipeName + " adicionada ao sistema com sucesso.");
    } 
}
