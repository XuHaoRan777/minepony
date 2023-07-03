package com.ruoyi.system.service;

import com.ruoyi.system.domain.MineponyServerFile;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * minepony 服务器文件 服务类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-03
 */
public interface MineponyServerFileService extends IService<MineponyServerFile> {

    // 上传服务器文件
    public String serverFileUpload(MultipartFile file,Long sysUserId);

    // 获取当前文件消息
    public String getServerFile();

    // 删除文件
    public String removeServerFile();
}
