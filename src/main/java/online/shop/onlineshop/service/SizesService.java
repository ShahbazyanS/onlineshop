package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Sizes;
import online.shop.onlineshop.repository.SizesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizesService {

    private final SizesRepository sizesRepository;

    public List<Sizes> allSizes(){
        return sizesRepository.findAll();
    }

}
