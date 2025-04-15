package BakeryManager.controller;

import BakeryManager.model.Items;
import BakeryManager.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items") //Define o prefixo base para todas as rotas deste controlador
public class ItemsController {

    @Autowired //Injeção de dependência automática do Spring
    private ItemsService itemsService; //Serviço que contém a lógica de negócio para itens

    //Retorna todos os itens cadastrados
    @GetMapping //Mapeia requisições GET para "/api/items"
    public List<Items> getAllItems() {
        return itemsService.findAll(); //Chama o serviço para obter todos os itens
    }

    //Retorna um item específico pelo ID
    @GetMapping("/{id}") //Mapeia requisições GET para "/api/items/{id}"
    public ResponseEntity<Items> getItemById(@PathVariable Long id) { //@PathVariable extrai o ID da URL 
        //Optional é usado para lidar com possíveis resultados nulos, evitando os temidos NullPointerException. Quando um método retorna Optional, fica claro desde a assinatura que o valor pode estar ausente e assim não precisa ler a documentação do projeto para saber.
        Optional<Items> item = itemsService.findById(id); //Busca o item no serviço
        //Retorna o item se encontrado, ou 404 se não existir
        return ResponseEntity.of(item);
    }

    //Cria um novo item
    @PostMapping //Mapeia requisições POST para "/api/items"
    public Items createItem(@RequestBody Items item) { //@RequestBody converte o JSON recebido para objeto Items
        return itemsService.save(item); //Salva o novo item através do serviço
    }

    //Atualiza um item existente
    @PutMapping("/{id}") //Mapeia requisições PUT para "/api/items/{id}"
    public ResponseEntity<Items> updateItem(@PathVariable Long id, @RequestBody Items itemDetails) {
        Optional<Items> item = itemsService.findById(id); //Verifica se o item existe
        if (item.isPresent()) {
            Items updatedItem = item.get(); //Obtém o item existente
            //Atualiza os campos do item
            updatedItem.setName(itemDetails.getName());
            updatedItem.setQuantity(itemDetails.getQuantity());
            updatedItem.setPrice(itemDetails.getPrice());
            return ResponseEntity.ok(itemsService.save(updatedItem)); //Salva as alterações
        }
        return ResponseEntity.notFound().build(); //Retorna 404 se o item não existir
    }

    //Remove um item
    @DeleteMapping("/{id}") //Mapeia requisições DELETE para "/api/items/{id}"
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemsService.deleteById(id); //Chama o serviço para deletar o item
        return ResponseEntity.noContent().build(); //Retorna status 204 (No Content)
    }
}