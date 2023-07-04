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
 * minepony 服务器公告
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-04
 */
@Getter
@Setter
@TableName("minepony_server_bulletin")
public class MineponyServerBulletin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务器公告内容
     */
    @TableField("content")
    private String content;

    /**
     * 更新日期
     */
    @TableField("updatetime")
    private Date updatetime;

    /**
     * 更新人
     */
    @TableField("updaterid")
    private Long updaterid;


}
