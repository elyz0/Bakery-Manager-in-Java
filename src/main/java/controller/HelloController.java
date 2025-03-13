package controller; //endpoint REST para testar a API

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Indica que esta classe é um controlador REST
@RequestMapping("/api")  // Define a URL base
public class HelloController {

    @GetMapping("/mensagem")  // Define um endpoint GET
    public String mensagem() {
        return "Olá, seu backend Spring Boot está funcionando!";
    }
}
