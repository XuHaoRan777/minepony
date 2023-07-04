package com.ruoyi.system.service.impl;

import com.mysql.cj.util.StringUtils;
import com.ruoyi.common.utils.AjaxJsonResult;
import com.ruoyi.system.domain.MineponyServerBulletin;
import com.ruoyi.system.domain.MineponyServerFile;
import com.ruoyi.system.mapper.MineponyServerBulletinMapper;
import com.ruoyi.system.service.MineponyServerBulletinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * minepony 服务器公告 服务实现类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-04
 */
@Service
public class MineponyServerBulletinServiceImpl extends ServiceImpl<MineponyServerBulletinMapper, MineponyServerBulletin> implements MineponyServerBulletinService {

    /**
     * 保存公告
     * @param serverBulletin
     * @param sysUserId
     * @return
     */
    @Override
    public String saveServerBulletin(MineponyServerBulletin serverBulletin, Long sysUserId) {
        try {
            // 服务器公告记录只保存一个，先查有没有记录，查到就修改那一条记录
            if(null == serverBulletin.getId() || 0 == serverBulletin.getId()){
                List<MineponyServerBulletin> list = list();
                if(list != null && list.size() > 0){
                    MineponyServerBulletin old_serverBulletin = list.get(0);
                    // 设置id
                    serverBulletin.setId(old_serverBulletin.getId());
                }
            }
            serverBulletin.setUpdaterid(sysUserId);
            serverBulletin.setUpdatetime(new Date());

            saveOrUpdate(serverBulletin);

            return AjaxJsonResult.success("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJsonResult.error("保存失败！");
        }


    }
}
