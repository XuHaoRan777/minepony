package com.ruoyi.system.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.AjaxJsonResult;
import com.ruoyi.system.domain.MineponyPromotionalImage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务器宣传图片 服务类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-02
 */
public interface MineponyPromotionalImageService extends IService<MineponyPromotionalImage> {

    // 保存上传的服务器宣传图片
    String uploadPromotionalImage(MultipartFile file, JSONObject jsonObject, Long sysUserId);

    // 启用或者禁用宣传图片
    String enablePromotionalImage(JSONObject jsonObject);

    // 删除宣传图片
    String removePromotionalImage(JSONObject jsonObject);
}
