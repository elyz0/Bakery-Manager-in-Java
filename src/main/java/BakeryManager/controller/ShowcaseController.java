package BakeryManager.controller;

import BakeryManager.model.Product;
import BakeryManager.services.Showcase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/showcase")
public class ShowcaseController {

    @Autowired
    private Showcase showcase;

    // Adiciona um produto à vitrine (via corpo da requisição JSON)
    @PostMapping("/add")
    public String addToShowcase(@RequestBody Product product) {
        return showcase.addToShowcase(product);
    }

    // Exibe todos os produtos da vitrine
    @GetMapping("/display")
    public Map<String, Product> displayShowcase() {
        return showcase.displayShowcase();
    }

    // Remove um produto específico
    @DeleteMapping("/remove/{productName}")
    public String removeFromShowcase(@PathVariable String productName) {
        return showcase.removeFromShowcase(productName);
    }

    // Limpa toda a vitrine
    @DeleteMapping("/clear")
    public void clearShowcase() {
        showcase.clearShowcase();
    }
}