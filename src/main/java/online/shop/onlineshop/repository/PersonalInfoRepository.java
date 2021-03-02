package online.shop.onlineshop.repository;

import online.shop.onlineshop.model.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> {

    PersonalInfo findByEmail(String email);
}
