package online.shop.onlineshop.repository;

import online.shop.onlineshop.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorsRepository extends JpaRepository<Color, Integer> {

}
