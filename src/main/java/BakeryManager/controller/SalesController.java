package BakeryManager.controller;

import BakeryManager.services.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    private final SalesService salesService;

    //quando uma classe tem apenas um construtor, o Spring automaticamente injetará as dependências sem a necessidade da anotação @Autowired.
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerSale(
            @RequestParam String productName,
            @RequestParam int quantity,
            @RequestParam String date) {
        
        try {
            salesService.registerSales(productName, quantity, date);
            return ResponseEntity.ok("Venda registrada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/products")
    public ResponseEntity<Map<String, Integer>> getProductSales() {
        return ResponseEntity.ok(salesService.getProductSales());
    }

    @GetMapping("/daily")
    public ResponseEntity<Map<String, Integer>> getDailySales() {
        return ResponseEntity.ok(salesService.getDailySales());
    }

    @GetMapping("/best-product")
    public ResponseEntity<String> getBestSellingProduct() {
        return ResponseEntity.ok(salesService.getBestSellingProduct());
    }

    @GetMapping("/best-day")
    public ResponseEntity<String> getBestSalesDay() {
        return ResponseEntity.ok(salesService.getBestSalesDay());
    }
}