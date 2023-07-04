package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.AjaxJsonResult;
import com.ruoyi.system.domain.MineponyServerBulletin;
import com.ruoyi.system.domain.MineponyServerIntroduction;
import com.ruoyi.system.mapper.MineponyServerIntroductionMapper;
import com.ruoyi.system.service.MineponyServerIntroductionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务器简介 服务实现类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-04
 */
@Service
public class MineponyServerIntroductionServiceImpl extends ServiceImpl<MineponyServerIntroductionMapper, MineponyServerIntroduction> implements MineponyServerIntroductionService {

    /**
     * 保存服务器简介
     * @param serverIntroduction
     * @param sysUserId
     * @return
     */
    @Override
    public String saveServerIntroduction(MineponyServerIntroduction serverIntroduction, Long sysUserId) {
        try {
            // 服务器公告记录只保存一个，先查有没有记录，查到就修改那一条记录
            if(null == serverIntroduction.getId() || 0 == serverIntroduction.getId()){
                List<MineponyServerIntroduction> list = list();
                if(list != null && list.size() > 0){
                    MineponyServerIntroduction old = list.get(0);
                    // 设置id
                    serverIntroduction.setId(old.getId());
                }
            }
            serverIntroduction.setUpdaterid(sysUserId);
            serverIntroduction.setUpdattime(new Date());

            saveOrUpdate(serverIntroduction);

            return AjaxJsonResult.success("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJsonResult.error("保存失败！");
        }
    }
}
