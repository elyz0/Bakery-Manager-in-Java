import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 

/*Gerencia a adição de novas receitas ao sistema, interage com a classe Stock para garantir que os ingredientes usados estejam no estoque. Se um ingrediente não existir, o usuário tem a opção de adicioná-lo.*/
 
public class RecipeManager(){ 
    private Stock items;  //verificar e adicionar ingredientes
    private Scanner scanner; //captura entrada e saida 
      
    /*Esse construtor é útil para que RecipeManager interaja diretamente com stock, sem ele precisaríamos criar um objeto stock, porem surgiria um erro, toda vez que fosse criado um RecipeManager, um novo Stock seria criado. Ou seja, diferentes partes do código estariam acessando estoques diferentes, e os ingredientes não seriam compartilhados corretamente. Logo um construtor é a maneira mais eficiente e segura de garantir que RecipeManager tenha acesso a um Stock já criado.*/
    public RecipeManager(Stock items) {  
        this.items = items; 
        this.scanner = new Scanner(System.in);  
    }

    
}