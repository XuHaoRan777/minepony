package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * minepony 服务器更新日志
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-02
 */
@Getter
@Setter
@TableName("minepony_server_update_log")
public class MineponyServerUpdateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 更新版本号
     */
    @TableField("version")
    private String version;

    /**
     * 更新描述
     */
    @TableField("description")
    private String description;

    /**
     * 创建时间
     */
    @TableField("createtime")
    private Date createtime;

    /**
     * 创建者
     */
    @TableField("createrid")
    private Long createrid;

    /**
     * 更新时间
     */
    @TableField("updatetime")
    private Date updatetime;

    /**
     * 更新人
     */
    @TableField("updaterid")
    private Long updaterid;


}
