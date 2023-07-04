package com.ruoyi.system.service;

import com.ruoyi.system.domain.MineponyServerUpdateLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * minepony 服务器更新日志 服务类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-02
 */
public interface MineponyServerUpdateLogService extends IService<MineponyServerUpdateLog> {

    // 获取更新日志列表
    public List<MineponyServerUpdateLog> getUpdateLogList(Map<String,Object> params);

    // 保存/更新日志
    public String saveServerUpdateLog(MineponyServerUpdateLog serverUpdateLog, Long SysUserId);

    // 删除日志
    public String removeServerUpdateLog(Integer id);

    // 获取服务器更新日志（倒叙）
    public List<MineponyServerUpdateLog> getUpdateListDesc();
}
