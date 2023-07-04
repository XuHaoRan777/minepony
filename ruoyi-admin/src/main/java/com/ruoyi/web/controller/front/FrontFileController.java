package com.ruoyi.web.controller.front;

import com.ruoyi.system.domain.MineponyServerFile;
import com.ruoyi.system.service.MineponyServerFileService;
import com.ruoyi.system.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/front/file")
public class FrontFileController {

    @Autowired
    MineponyServerFileService serverFileService;

    // 网站宣传图片地址
    private final Path promotionalImagePath = Paths.get(Constants.Promotional_Image_PATH).toAbsolutePath().normalize();

    /**
     * 获取网站宣传图片
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
    /**
     * 获取服务器文件
     * @param response
     * @return
     */
    @GetMapping("/serverFile")
    public void serverFile(HttpServletResponse response) {
        OutputStream out = null;
        FileInputStream in = null;
        BufferedInputStream br = null;
        try {
            // 1.读取要下载的内容
            MineponyServerFile serverFile = new MineponyServerFile();
            List<MineponyServerFile> list = serverFileService.list();
            if(list != null && list.size() > 0){
                serverFile = list.get(0);
            }else {
                // 设置一个404状态码来表示文件未找到
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("File not found");
                return;
            }
            in = new FileInputStream(serverFile.getSavepath());
            br = new BufferedInputStream(in);
            byte[] buf = new byte[1024];
            int len = 0;


            // 设置一个响应头，无论是否被浏览器解析，都下载
            response.setHeader("Content-Disposition", "attachment;fileName="
                    + URLEncoder.encode(serverFile.getFilename(), "UTF-8"));

            // 将要下载的文件内容通过输出流写到浏览器
            out = response.getOutputStream();
            while ((len = br.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            br.close();
            out.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (br != null) {
                    br.close();
                }
                if (in != null) {
                    in.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
