package BakeryManager.controller;

import BakeryManager.services.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pricing")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @GetMapping("/price/{ingredientName}")
    public double getIngredientPrice(@PathVariable String ingredientName) {
        return pricingService.getPrice(ingredientName);
    }

    @GetMapping("/product/{productName}")
    public double calculateProductPrice(
            @PathVariable String productName,
            @RequestParam double profitMargin) {
        return pricingService.calculateProductPrice(productName, profitMargin);
    }
}