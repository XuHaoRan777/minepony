package com.ruoyi.web.controller.front;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.MineponyServerBulletin;
import com.ruoyi.system.domain.MineponyServerIntroduction;
import com.ruoyi.system.domain.MineponyServerUpdateLog;
import com.ruoyi.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/front")
public class FrontIndexController extends BaseController {

    @Autowired
    MineponyPromotionalImageService promotionalImageService;
    @Autowired
    MineponyServerUpdateLogService serverUpdateLogService;
    @Autowired
    MineponyServerBulletinService serverBulletinService;
    @Autowired
    MineponyServerIntroductionService serverIntroductionService;

    private String prefix = "front/";

    /**
     * 宣传网站页面
     * @return
     */
    @GetMapping("/minepony")
    public String frontHomePage(ModelMap mmap){
        return prefix + "plan1/index";
    }

    /**
     * 宣传网站 - 宣传图片管理
     * @return
     */
    @GetMapping("/imageManagement")
    public String imageManagement(){
        return prefix + "manager/imageManagement/imageManagement";
    }

    /**
     * 宣传网站 - 更新日志管理
     * @return
     */
    @GetMapping("/updateLogManageManagement")
    public String updateLogManageManagement(){
        return prefix + "manager/serverupdatelog/updateLogManagement";
    }

    /**
     * 宣传网站 - 更新日志保存
     * @return
     */
    @GetMapping("/serverUpdateLogAdd/{id}")
    public String serverUpdateLogAdd(@PathVariable("id") String id, ModelMap mmap){
        mmap.put("updateLog",id.equals("n") ? new MineponyServerUpdateLog() : serverUpdateLogService.getById(Integer.valueOf(id)));
        return prefix + "manager/serverupdatelog/serverUpdateLogAdd";
    }

    /**
     * 宣传网站 - 服务器文件上传
     * @return
     */
    @GetMapping("/serverFileUpload")
    public String serverFileUpload(){
        return prefix + "manager/serverfile/serverFileUpload";
    }

    /**
     * 宣传网站 - 服务器公告编辑
     * @return
     */
    @GetMapping("/serverBulletin")
    public String serverBulletin(ModelMap mmap){
        MineponyServerBulletin serverBulletin = new MineponyServerBulletin();
        List<MineponyServerBulletin> list = serverBulletinService.list();
        if(list != null && list.size() > 0){
            serverBulletin = list.get(0);
        }
        mmap.put("serverBulletin",serverBulletin);
        return prefix + "manager/serverBulletin/serverBulletinManagement";
    }

    /**
     * 宣传网站 - 服务器简介编辑
     * @return
     */
    @GetMapping("/serverIntroduction")
    public String serverIntroduction(ModelMap mmap){
        MineponyServerIntroduction serverIntroduction = new MineponyServerIntroduction();
        List<MineponyServerIntroduction> list = serverIntroductionService.list();
        if(list != null && list.size() > 0){
            serverIntroduction = list.get(0);
        }
        mmap.put("serverIntroduction",serverIntroduction);
        return prefix + "manager/serverIntroduction/serverIntroduction";
    }




}
