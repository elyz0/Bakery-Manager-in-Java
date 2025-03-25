package BakeryManager.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity 
@DiscriminatorValue("INGREDIENT") //Valor do discriminador para Ingredients 
//@Table(name = "BM_INGREDIENT") É uma classe filha então não pode, só no pai
public class Ingredients extends Items{ //São os ingredientes que estarão no estoque da bakery. Necessário adicionar a quantidade e o valor por qual foi comprado.
     
    public Ingredients() {
        // Construtor padrão (obrigatório para JPA)
    } 
    
    public Ingredients(String name, int quantity, double price){ //construtor tem que ter o nome da classe
        super(name, quantity, price);
    };  

}
