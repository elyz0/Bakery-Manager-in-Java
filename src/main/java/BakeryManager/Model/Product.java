package BakeryManager.model;
 
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity 
@DiscriminatorValue("PRODUCT") //Valor do discriminador para Product
public class Product extends Items{ 
    //É a receita já produzida (Comidas para irem a vitrine)
    
    public Product() {
        // Construtor padrão (obrigatório para JPA)
    } 

    public Product(String name, int quantity, double price) {
        super(name, quantity, price);
    } 

}
