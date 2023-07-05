package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.MineponyServerUpdateLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * minepony 服务器更新日志 Mapper 接口
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-02
 */
@Mapper
public interface MineponyServerUpdateLogMapper extends BaseMapper<MineponyServerUpdateLog> {

    // 更新日志维护页面列表查询
    List<MineponyServerUpdateLog> getUpdateLogList(Map<String,Object> params);

    // 宣传页面日志记录获取
    List<MineponyServerUpdateLog> getUpdateListDesc(Map<String,Object> params);
}
