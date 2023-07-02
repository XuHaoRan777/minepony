package com.ruoyi.web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class FrontIndexController {

    private String prefix = "front/";

    @GetMapping("")
    public String frontHomePage(){
        return prefix + "index";
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
     * 宣传网站 - 更新日志新增
     * @return
     */
    @GetMapping("/serverUpdateLogAdd")
    public String serverUpdateLogAdd(){
        return prefix + "manager/serverupdatelog/serverUpdateLogAdd";
    }

}
