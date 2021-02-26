package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Colors;
import online.shop.onlineshop.repository.ColorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorsService {

    private final ColorsRepository colorsRepository;

    public List<Colors> colors(){
        return colorsRepository.findAll();
    }
}
