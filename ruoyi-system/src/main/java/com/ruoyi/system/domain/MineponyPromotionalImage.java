package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 服务器宣传图片
 * </p>
 *
 * @author CodeXu
 * @since 2023-07-02
 */
@Data
@TableName("minepony_promotional_image")
public class MineponyPromotionalImage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 是否启用（0:禁用, 1:启用）
     */
    @TableField("enable")
    private Integer enable;

    /**
     * 图片名称
     */
    @TableField("imagename")
    private String imagename;

    /**
     * 保存路径
     */
    @TableField("savepath")
    private String savepath;

    /**
     * 上传日期
     */
    @TableField("uploaddate")
    private Date uploaddate;

    /**
     * 上传人id
     */
    @TableField("uploaderid")
    private Long uploaderid;
}
