package com.ruoyi.system.service;

import com.ruoyi.system.domain.MineponyServerIntroduction;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务器简介 服务类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-04
 */
public interface MineponyServerIntroductionService extends IService<MineponyServerIntroduction> {
    // 保存服务器简介
    public String saveServerIntroduction(MineponyServerIntroduction serverIntroduction,Long sysUserId);

    // 保存服务器简介图片
    public String saveIntroductionImage(MultipartFile file, Long sysUserId);

    // 获取当前服务器宣传信息
    public String getServerIntroduction();
}
