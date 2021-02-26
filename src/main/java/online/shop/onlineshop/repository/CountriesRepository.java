package online.shop.onlineshop.repository;

import online.shop.onlineshop.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer> {
}
