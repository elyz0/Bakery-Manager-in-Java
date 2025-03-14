package BakeryManager;

 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //habilita a configuração automática e o escaneamento de componentes. As anotações fazem uma configuração não visivel. Essa é a junção de 3: @configuration, @enableautoconfiguration e @componentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // Inicia a aplicação Spring Boot.
        System.out.println("🚀 Spring Boot rodando na porta 8080!"); //Inicia um servidor na porta 8080 automaticamente.
    }
}
