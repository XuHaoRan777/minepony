package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * minepony 服务器文件
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-03
 */
@Getter
@Setter
@TableName("minepony_server_file")
public class MineponyServerFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务包文件名
     */
    @TableField("filename")
    private String filename;

    /**
     * 保存路径
     */
    @TableField("savepath")
    private String savepath;

    /**
     * 上传时间
     */
    @TableField("uploadtime")
    private Date uploadtime;

    /**
     * 上传人
     */
    @TableField("uploaderid")
    private Long uploaderid;


}
