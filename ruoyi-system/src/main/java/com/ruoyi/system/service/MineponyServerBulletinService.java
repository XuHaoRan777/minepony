package com.ruoyi.system.service;

import com.ruoyi.system.domain.MineponyServerBulletin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * minepony 服务器公告 服务类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-04
 */
public interface MineponyServerBulletinService extends IService<MineponyServerBulletin> {
    // 保存公告
    public String saveServerBulletin(MineponyServerBulletin serverBulletin,Long sysUserId);
}
