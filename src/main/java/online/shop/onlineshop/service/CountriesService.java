package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Countrie;
import online.shop.onlineshop.repository.CountriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountriesService implements CountriesServiceImpl{

    private final CountriesRepository countriesRepository;

    @Override
    public List<Countrie> countries(){
        return countriesRepository.findAll();
    }
}
