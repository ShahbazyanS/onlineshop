package online.shop.onlineshop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    public void uploadToLocal(MultipartFile file) {
        try {
            String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File image = new File(uploadDir, name);
            file.transferTo(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
