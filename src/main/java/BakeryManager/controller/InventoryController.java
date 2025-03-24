package BakeryManager.controller;
 
import BakeryManager.services.InventoryManager;
import BakeryManager.model.Items; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory") //Define o prefixo da URL para todos os endpoints deste controlador
public class InventoryController {
 
    @Autowired //Spring
    private InventoryManager inventoryManager;  //Declara o serviço que será usado pelo controlador 
 
    //Mapeia requisições HTTP POST para "/inventory/add"
    @PostMapping("/add")    
    public String addItem(@RequestParam String itemName, @RequestParam int quantity) { 
        inventoryManager.addItem(itemName, quantity);  
        return "Item added: " + itemName + ", Quantity: " + quantity;  
    }  
      
    //Mapeia requisições HTTP POST para "/inventory/remove"
    @PostMapping("/remove")  
    public String removeItem(@RequestParam String itemName, @RequestParam int quantity) { 
        inventoryManager.removeItem(itemName, quantity);  
        return "Item removed: " + itemName + ", Quantity: " + quantity;  
    }
 
    //Mapeia requisições HTTP GET para "/inventory/check"
    @GetMapping("/check")  
    public int checkInventory(@RequestParam String itemName) {  //Método que verifica a quantidade em estoque
        return inventoryManager.checkInventory(itemName);  
    }
 
    //Mapeia requisições HTTP GET para "/inventory/item"
    @GetMapping("/item")  
    public Items getItem(@RequestParam String ingredientName) {  
        return inventoryManager.getItem(ingredientName);  
    }

}
