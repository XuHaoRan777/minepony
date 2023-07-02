package com.ruoyi.web.controller.front;

import com.ruoyi.system.utils.Constants;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
@Controller
@RequestMapping("/front/file")
public class FrontFileController {

    // 网站宣传图片地址
    private final Path promotionalImagePath = Paths.get(Constants.Promotional_Image_PATH).toAbsolutePath().normalize();

    /**
     * 获取完整宣传图片
     * @param fileName
     * @return
     */
    @GetMapping("/promotionalImage/{fileName:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String fileName) {
        try {
            Path filePath = this.promotionalImagePath.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException ex) {
            return ResponseEntity.badRequest().build();
        }
    }


}
