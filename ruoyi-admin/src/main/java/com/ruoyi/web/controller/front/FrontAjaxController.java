package com.ruoyi.web.controller.front;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.AjaxJsonResult;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.MineponyServerUpdateLog;
import com.ruoyi.system.service.MineponyPromotionalImageService;
import com.ruoyi.system.service.MineponyServerFileService;
import com.ruoyi.system.service.MineponyServerUpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 关于宣传网站的信息操作
 */
@CrossOrigin
@RestController
@RequestMapping("/front/ajax")
public class FrontAjaxController extends BaseController{

    @Autowired
    MineponyPromotionalImageService promotionalImageService;
    @Autowired
    MineponyServerUpdateLogService serverUpdateLogService;
    @Autowired
    MineponyServerFileService serverFileService;

    /**
     * 获取服务器宣传图片列表
     * @return
     */
    @PostMapping("/promotionalImageList")
    public String promotionalImageList(){
        return JSONObject.toJSONString(promotionalImageService.list());
    }

    /**
     * 上传服务器宣传图片列表
     * @param file
     * @param params
     * @return
     */
    @PostMapping("/savePromotionalImage")
    public String savePromotionalImage(MultipartFile file,@RequestParam String params){
        return promotionalImageService.uploadPromotionalImage(file,JSONObject.parseObject(params), ShiroUtils.getUserId());
    }

    /**
     * 启用/禁用宣传图片
     * @param params
     * @return
     */
    @PostMapping("/enablePromotionalImage")
    public String enablePromotionalImage(@RequestBody String params){
        return promotionalImageService.enablePromotionalImage(JSONObject.parseObject(params));
    }

    /**
     * 删除宣传图片
     * @return
     */
    @PostMapping("/removePromotionalImage")
    public String removePromotionalImage(@RequestBody String params){
        return promotionalImageService.removePromotionalImage(JSONObject.parseObject(params));
    }

    /**
     * 获取更新日志列表
     * @param params
     * @return
     */
    @PostMapping("/serverUpdateLogList")
    public List<MineponyServerUpdateLog> serverUpdateLogList(@RequestParam Map<String,Object> params){
        startPage();
        List<MineponyServerUpdateLog> list = serverUpdateLogService.getUpdateLogList(params);
        return list;
    }

    /**
     * 保存服务器更新日志
     * @param serverUpdateLog
     * @return
     */
    @PostMapping("/saveUpdateLog")
    public String saveUpdateLog(@RequestBody MineponyServerUpdateLog serverUpdateLog){
        return serverUpdateLogService.saveServerUpdateLog(serverUpdateLog,ShiroUtils.getUserId());
    }

    /**
     * 删除服务器更新日志
     * @param id
     * @return
     */
    @PostMapping("/removeUpdateLog/{id}")
    public String removeUpdateLog(@PathVariable("id") String id){
        return serverUpdateLogService.removeServerUpdateLog(Integer.valueOf(id));
    }

    /**
     * 上传服务器文件
     * @param file
     * @return
     */
    @PostMapping("/serverFileUpload")
    public String serverFileUpload(MultipartFile file){
        return serverFileService.serverFileUpload(file,ShiroUtils.getUserId());
    }

    /**
     * 获取当前服务器文件消息
     * @return
     */
    @PostMapping("/getServerFile")
    public String getServerFile(){
        return serverFileService.getServerFile();
    }

    /**
     * 删除当前服务器文件信息
     * @return
     */
    @PostMapping("/removeServerFile")
    public String removeServerFile(){
        return serverFileService.removeServerFile();
    }
}
