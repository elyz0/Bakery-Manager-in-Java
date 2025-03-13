package Main;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 

public class BakeryManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BakeryManagerApplication.class, args);
        System.out.println("🚀 Spring Boot rodando na porta 8080!"); //Inicia um servidor na porta 8080 automaticamente.
    }
}
