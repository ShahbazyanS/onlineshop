package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Size;
import online.shop.onlineshop.repository.SizesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizesServiceImpl implements SizesService {

    private final SizesRepository sizesRepository;

    @Override
    public List<Size> allSizes(){
        return sizesRepository.findAll();
    }

}
