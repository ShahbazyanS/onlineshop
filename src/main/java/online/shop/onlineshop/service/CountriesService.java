package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Countries;
import online.shop.onlineshop.repository.CountriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountriesService {

    private final CountriesRepository countriesRepository;

    public List<Countries> countries(){
        return countriesRepository.findAll();
    }
}
