package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.AjaxJsonResult;
import com.ruoyi.system.domain.MineponyPromotionalImage;
import com.ruoyi.system.mapper.MineponyPromotionalImageMapper;
import com.ruoyi.system.service.MineponyPromotionalImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.utils.Constants;
import com.ruoyi.system.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * <p>
 * 服务器宣传图片 服务实现类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-02
 */
@Service
public class MineponyPromotionalImageServiceImpl extends ServiceImpl<MineponyPromotionalImageMapper, MineponyPromotionalImage> implements MineponyPromotionalImageService {

    /**
     * 上传服务器宣传图片
     * @param file
     * @param jsonObject
     * @return
     */
    @Override
    public String uploadPromotionalImage(MultipartFile file, JSONObject jsonObject, Long sysUserId) {
        MineponyPromotionalImage image = new MineponyPromotionalImage();
        image.setUploaderid(sysUserId);
        try {
            // 保存文件
            FileUtil.saveFile(file.getInputStream(), Constants.Promotional_Image_PATH,file.getOriginalFilename());
            // 保存记录
            image.setImagename(file.getOriginalFilename());
            image.setUploaderid(sysUserId);
            image.setUploaddate(new Date());
            image.setSavepath(Constants.Promotional_Image_PATH + file.getOriginalFilename());
            // 默认禁用
            image.setEnable(0);
            save(image);
            return AjaxJsonResult.success("上传成功！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJsonResult.error("上传失败！");
        }
    }

    /**
     * 启用或者禁用宣传图片
     * @param jsonObject
     * @return
     */
    @Override
    public String enablePromotionalImage(JSONObject jsonObject) {
        try {
            // 更新 enable
            Integer id = jsonObject.getInteger("imageId");
            Integer enable = jsonObject.getInteger("enable");
            MineponyPromotionalImage image = this.getById(id);
            image.setEnable(enable);
            updateById(image);
            return AjaxJsonResult.success("设置成功！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJsonResult.error("设置失败！");
        }
    }

    /**
     * 删除宣传图片
     * @param jsonObject
     * @return
     */
    @Override
    public String removePromotionalImage(JSONObject jsonObject) {
        try {
            // 删除文件和记录
            Integer id = jsonObject.getInteger("imageId");
            MineponyPromotionalImage image = this.getById(id);
            // 获取保存全路径，删除文件
            String savepath = image.getSavepath();
            FileUtil.deleteFile(savepath);
            removeById(id);
            return AjaxJsonResult.success("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJsonResult.error("删除失败！");
        }
    }


}
