package BakeryManager.services;

import BakeryManager.model.Items;
import BakeryManager.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public List<Items> findAll() {
        return itemsRepository.findAll();
    }

    public Optional<Items> findById(Long id) {
        return itemsRepository.findById(id);
    }

    public Items findByName(String name) {
        return itemsRepository.findByName(name);
    }

    public Items save(Items item) {
        return itemsRepository.save(item);
    }

    public void deleteById(Long id) {
        itemsRepository.deleteById(id);
    }
}