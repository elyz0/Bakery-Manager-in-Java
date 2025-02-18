package Model;
 
//São os ingredientes que estarão no estoque da bakery. Necessário adicionar a quantidade e o valor por qual foi comprado.
public class Ingredients extends Items{ 
    
    public Ingredients(String name, int quantity, double price){ //construtor tem que ter o nome da classe
        super(name, quantity, price);
    };  

}
