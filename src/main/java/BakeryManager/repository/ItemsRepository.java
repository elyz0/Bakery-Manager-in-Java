package BakeryManager.repository;

import BakeryManager.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {
    Items findByName(String name);
}