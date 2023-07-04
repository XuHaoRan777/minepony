package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.utils.AjaxJsonResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.MineponyServerUpdateLog;
import com.ruoyi.system.mapper.MineponyServerUpdateLogMapper;
import com.ruoyi.system.service.MineponyServerUpdateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * minepony 服务器更新日志 服务实现类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-02
 */
@Service
public class MineponyServerUpdateLogServiceImpl extends ServiceImpl<MineponyServerUpdateLogMapper, MineponyServerUpdateLog> implements MineponyServerUpdateLogService {

    /**
     * 获取更新日志列表
     * @param params
     * @return
     */
    @Override
    public List<MineponyServerUpdateLog> getUpdateLogList(Map<String, Object> params) {
        return baseMapper.getUpdateLogList(params);
    }

    /**
     * 保存/更新日志
     * @param serverUpdateLog
     * @return
     */
    @Override
    public String saveServerUpdateLog(MineponyServerUpdateLog serverUpdateLog, Long SysUserId) {
        try {
            // 保存
            if(StringUtils.isNotNull(serverUpdateLog.getId()) && serverUpdateLog.getId() != 0){
                // 设置更新信息
                serverUpdateLog.setUpdaterid(SysUserId);
                serverUpdateLog.setUpdatetime(new Date());

                updateById(serverUpdateLog);
            }else {
                serverUpdateLog.setCreaterid(SysUserId);
                serverUpdateLog.setCreatetime(new Date());

                save(serverUpdateLog);
            }

            return AjaxJsonResult.success("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJsonResult.error("保存失败！");
        }
    }

    /**
     * 删除日志
     * @param id
     * @return
     */
    @Override
    public String removeServerUpdateLog(Integer id) {
        try {
            // 删除
            this.removeById(id);

            return AjaxJsonResult.success("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJsonResult.error("删除失败！");
        }
    }

    /**
     * 获取服务器更新日志（倒叙）
     * @return
     */
    @Override
    public List<MineponyServerUpdateLog> getUpdateListDesc() {
        QueryWrapper<MineponyServerUpdateLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return list(queryWrapper);
    }
}
