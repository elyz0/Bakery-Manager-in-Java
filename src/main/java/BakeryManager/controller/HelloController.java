package BakeryManager.controller; //endpoint REST para testar a API

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Indica que esta classe é um controlador REST
@RequestMapping("/api")  // Define o caminho (URL) base para os endpoints. 
public class HelloController {

    @GetMapping("/mensagem")  // Qual método http esse método responde? Mapeia requisições GET para o método / define um endpoint GET
    public String mensagem() {
        return "Olá, seu backend Spring Boot está funcionando!";
    }
}
