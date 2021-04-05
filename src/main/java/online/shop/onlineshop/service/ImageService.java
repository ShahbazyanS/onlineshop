package online.shop.onlineshop.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void save(int id, MultipartFile file);
}
