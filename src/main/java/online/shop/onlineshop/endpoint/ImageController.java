package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.service.ImageServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {

    private final ImageServiceImpl imageService;

    @PostMapping("/upload/local")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        imageService.uploadToLocal(file);
    }

    @PostMapping("/upload/db")
    public void uploadDb(@RequestParam("file") MultipartFile file) {

    }
}
