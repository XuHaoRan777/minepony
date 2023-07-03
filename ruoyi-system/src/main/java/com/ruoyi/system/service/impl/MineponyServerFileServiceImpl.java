package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.AjaxJsonResult;
import com.ruoyi.system.domain.MineponyServerFile;
import com.ruoyi.system.mapper.MineponyServerFileMapper;
import com.ruoyi.system.service.MineponyServerFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.utils.Constants;
import com.ruoyi.system.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * minepony 服务器文件 服务实现类
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-03
 */
@Service
public class MineponyServerFileServiceImpl extends ServiceImpl<MineponyServerFileMapper, MineponyServerFile> implements MineponyServerFileService {

    /**
     * 上传服务器文件
     * @param file
     * @param sysUserId
     * @return
     */
    @Override
    public String serverFileUpload(MultipartFile file, Long sysUserId) {
        try {
            // 服务器文件只保存一个，每次更新文件先删除原来的文件记录，再上传新的
            MineponyServerFile serverFile = new MineponyServerFile();
            List<MineponyServerFile> list = list();
            if(list != null && list.size() > 0){
                serverFile = list.get(0);
                // 删除文件
                FileUtil.deleteFile(serverFile.getSavepath());
            }
            // 上传文件
            FileUtil.saveFile(file.getInputStream(), Constants.SERVER_FILE_PATH,file.getOriginalFilename());
            // 保存记录
            serverFile.setFilename(file.getOriginalFilename());
            serverFile.setUploaderid(sysUserId);
            serverFile.setUploadtime(new Date());
            serverFile.setSavepath(Constants.SERVER_FILE_PATH + file.getOriginalFilename());

            saveOrUpdate(serverFile);
            return AjaxJsonResult.success("上传成功！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJsonResult.error("上传失败！");
        }
    }

    /**
     * 获取当前文件消息
     * @return
     */
    @Override
    public String getServerFile() {
        MineponyServerFile serverFile = new MineponyServerFile();
        List<MineponyServerFile> list = list();
        if(list != null && list.size() > 0){
            serverFile = list.get(0);
        }
        return AjaxJsonResult.success(serverFile);
    }

    /**
     * 删除文件
     * @return
     */
    @Override
    public String removeServerFile() {
        try {
            MineponyServerFile serverFile = new MineponyServerFile();
            List<MineponyServerFile> list = list();
            if(list != null && list.size() > 0){
                serverFile = list.get(0);
                // 删除文件
                FileUtil.deleteFile(serverFile.getSavepath());
                // 删除记录
                removeById(serverFile.getId());
            }
            return AjaxJsonResult.success("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxJsonResult.error("删除失败！");
        }
    }
}
