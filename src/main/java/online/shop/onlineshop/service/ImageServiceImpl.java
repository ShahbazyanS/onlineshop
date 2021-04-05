package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Image;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.repository.ImageRepository;
import online.shop.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    private final ImageRepository imageRepository;
    private final ProductRepository productRepository;

    public void save(int productId, MultipartFile file) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            String name = UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename();
            File picCar = new File(uploadDir, name);
            Image images = Image.builder()
                    .name(name)
                    .product(product.get())
                    .build();
            try {
                file.transferTo(picCar);
                imageRepository.save(images);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
