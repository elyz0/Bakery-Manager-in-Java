package Services;

import java.util.HashMap;
import java.util.Map;

import Model.Items;

public class Stock { 
      
    Stock stock;

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
    public int checkStock(  String itemName) {  

        Items item = items.get(itemName); //Get busca o objeto associado ao nome
        return item != null ? item.getQuantity() : 0; //Se diferente de null (encontrado) então retorna a qntd, se não, retorna 0. 

    } 
      
    //Método para armazenar a receita de um produto, ela utiliza os ingredientes do estoque
    public void addRecipe(Map<String, Integer> ingredients, String productName, int BakingTime) { 

        recipes.put(productName, ingredients); 

    } 
     
    // Método para obter uma receita
    public Map<String, Integer> getRecipe(String recipeName) { 

        return recipes.getOrDefault(recipeName, null); 

    } 
     
    //Método para obter o preço do ingrediente 
    public double getPrice(String ingredientName) {  

        Items item = items.get(ingredientName); 

        if (item != null) {
            return item.getPrice();  // Já podemos acessar getPrice() diretamente porque está na classe base (Items)
        } else {
            return 0.0;  // Se o item não existir, retorna 0.0
        } 

    } 
     
    /* lidar com um mapa (Map) que armazena itens de tipo genérico Items, mas tentar acessar informações específicas de uma subclasse (Ingredients). Quando você usa o Map<String, Items>, a ideia é que o mapa armazene objetos do tipo Items, que podem ser de qualquer subclasse de Items (como Ingredients). Então, quando você obtém o objeto do mapa com items.get(ingredientName), o que você recebe é um Items genérico, e não um Ingredients específico. Agora, como o método getPrice() está em Items, você deveria ser capaz de chamá-lo diretamente no objeto retornado, sem a necessidade de cast, porque o método getPrice() está disponível para todos os objetos do tipo Items e suas subclasses (como Ingredients).

O que pode ter confundido inicialmente é que, ao tentar acessar o preço de um ingrediente, você sabia que esse ingrediente era um Ingredients, mas o mapa estava retornando um Items. Isso normalmente nos faz pensar que precisaremos fazer um cast para acessar métodos específicos de subclasses, mas no seu caso, isso não era necessário, porque Ingredients herda de Items e, portanto, todos os métodos públicos de Items, como getPrice(), também estão disponíveis para objetos do tipo Ingredients.*/
       
}
