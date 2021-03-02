package online.shop.onlineshop.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageServiceImpl {

    public void uploadToLocal(MultipartFile file);
}
