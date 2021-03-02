package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Color;
import online.shop.onlineshop.repository.ColorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorsServiceImpl implements ColorsService {

    private final ColorsRepository colorsRepository;

    @Override
    public List<Color> colors(){
        return colorsRepository.findAll();
    }
}
