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
 * 服务器简介
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-04
 */
@Getter
@Setter
@TableName("minepony_server_introduction")
public class MineponyServerIntroduction implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务器简介标题
     */
    @TableField("title")
    private String title;

    /**
     * 服务器简介内容
     */
    @TableField("content")
    private String content;

    /**
     * 更新时间
     */
    @TableField("updattime")
    private Date updattime;

    /**
     * 更新人
     */
    @TableField("updaterid")
    private Long updaterid;


}
