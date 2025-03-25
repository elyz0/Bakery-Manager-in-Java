package BakeryManager.controller;

import BakeryManager.model.Items;
import BakeryManager.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping
    public List<Items> getAllItems() {
        return itemsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Items> getItemById(@PathVariable Long id) {
        Optional<Items> item = itemsService.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Items createItem(@RequestBody Items item) {
        return itemsService.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Items> updateItem(@PathVariable Long id, @RequestBody Items itemDetails) {
        Optional<Items> item = itemsService.findById(id);
        if (item.isPresent()) {
            Items updatedItem = item.get();
            updatedItem.setName(itemDetails.getName());
            updatedItem.setQuantity(itemDetails.getQuantity());
            updatedItem.setPrice(itemDetails.getPrice());
            return ResponseEntity.ok(itemsService.save(updatedItem));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}