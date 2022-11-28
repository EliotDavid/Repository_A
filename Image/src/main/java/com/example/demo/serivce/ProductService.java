package com.example.demo.serivce;

import com.example.demo.domain.ImageObject;
import com.example.demo.dto.ProductDto;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Transactional(readOnly = true) // 읽기전용
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //@Transactional(readOnly = false)
    @Transactional
    public void save(MultipartFile file, ProductDto dto) throws Exception {

        String filePath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\static\\images";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();

        File saved = new File(filePath, fileName);
        file.transferTo(saved);

        ImageObject product = new ImageObject(
                dto.getTitle(),
                dto.getContent(),
                dto.getCount(),
                dto.getPrice(),
                filePath, fileName);
    }
}
