package com.ruoyi.web.controller.front;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.MineponyServerUpdateLog;
import com.ruoyi.system.service.MineponyServerUpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class FrontIndexController extends BaseController {

    @Autowired
    MineponyServerUpdateLogService serverUpdateLogService;

    private String prefix = "front/";

    @GetMapping("/minepony")
    public String frontHomePage(){
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



}
