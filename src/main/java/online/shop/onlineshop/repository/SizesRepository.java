package online.shop.onlineshop.repository;

import online.shop.onlineshop.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizesRepository extends JpaRepository<Size, Integer> {
}
