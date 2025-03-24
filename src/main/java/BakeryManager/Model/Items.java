package BakeryManager.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity; //usada quando você quer que a classe Items seja mapeada para uma tabela em um banco de dados. Isso faz parte do JPA (Java Persistence API), que é uma especificação para persistência de dados em Java.
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity 
@Table(name = "BM_ITEMS") //Nome da tabela no banco de dados   
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Estratégia de herança
@DiscriminatorColumn(name = "ITEM_TYPE", discriminatorType = DiscriminatorType.STRING) // Coluna de discriminação
public class Items { 
      
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Atributo que identifica a tabela no banco de dados e que é gerado automaticament
    private Long id; //Atributo que representa a chave primária da tabela 
 
    @Column(nullable = false, unique = true) //Não pode ser nulo e deve ter nome único
    private String name;  

    @Column(nullable = false)
    private int quantity;   

    @Column(nullable = false)
    private double price;

    public Items(String name, int quantity, double price) { 
        this.name = name;
        this.quantity = quantity; 
        this.price = price;
    }
   
    //Construtor padrão (obrigatório para JPA)
     public Items() {
    } 

    //É recomendável adicionar métodos setters para todos os atributos
    public void setId(Long id) {
        this.id = id;
    } 

    public Long getId() {
        return id;
    }  

    public void setName(String name) {
        this.name = name;
    } 

    public String getName() {
        return name;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } 

    public int getQuantity() {
        return quantity;
    } 
 
    public void setPrice(double price) {
        this.price = price;
    } 

    public double getPrice() {
        return price;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public boolean removeQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        }
        return false;
    }
}
