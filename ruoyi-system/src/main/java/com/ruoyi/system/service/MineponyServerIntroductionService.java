package com.ruoyi.system.service;

import com.ruoyi.system.domain.MineponyServerIntroduction;
import com.baomidou.mybatisplus.extension.service.IService;

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

}
