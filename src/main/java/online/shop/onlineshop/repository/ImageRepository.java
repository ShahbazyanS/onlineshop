package online.shop.onlineshop.repository;

import online.shop.onlineshop.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Images, Integer> {
}
