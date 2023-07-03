package com.ruoyi.common.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class MPCodeGenerator {
    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
        tables.add("minepony_server_file");
        //tables.add("");
        FastAutoGenerator.create("jdbc:mysql://117.50.192.56:3306/minepony?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8","root","MuShaxhrxxh777")
                .globalConfig(builder -> {
                    //全局配置
                    builder.author("CodeXu") // 作者
                            .outputDir(System.getProperty("user.dir")+"\\ruoyi-system\\src\\main\\java")   //输出路径（写到java目录）
                            //.enableSwagger() // 开启 swagger 模式 默认值:false
                            .commentDate("yyyy-MM-dd")
                            .fileOverride();  // 开启覆盖之前生成的文件
                })
                .packageConfig(builder -> {
                    // 包配置
                    builder.parent("com.ruoyi.system") // 父包模块名 默认值:com.baomidou
                            //.moduleName("")
                            .entity("domain")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper");                        // pathInfo 是这是这些包放在哪，xml一般都是在resource下，所以需要额外处理一下
                            //.pathInfo(Collections.singletonMap(OutputFile.mapperXml,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    // 策略配置
                    builder.addInclude(tables)      // 配置要生成表的声明，这里使用的是list
                            //.addTablePrefix("m_") // 过滤表明前缀，如 p_test，我们生成的类型只需要test
                            .controllerBuilder()    // controller 策略配置
                            .formatFileName("%sController") // 格式化 Controller 名称
                            .enableRestStyle()      // 开启 RestController
                            .serviceBuilder()       // service 策略配置
                            .formatServiceFileName("%sService")          // service类型，  %s 适配。根据表名替换
                            .formatServiceImplFileName("%sServiceImpl")  // 格式化 Service 名称
                            .entityBuilder()        // 实体类策略配置
                            .enableLombok()         // 开启Lombok
                            //.logicDeleteColumnName("status")// 说明逻辑删除是哪个字段
                            .enableTableFieldAnnotation()     // 属性加上说明注解

                            .mapperBuilder()        // mapper 策略配置
                            .superClass(BaseMapper.class)    // 继承哪个父类
                            .formatMapperFileName("%sMapper")// 格式化 mapper 名称
                            .enableMapperAnnotation()        // @mapper开启
                            .enableBaseColumnList()          // 通用查询列
                            .enableBaseResultMap()           // 结果集映射Map
                            .formatXmlFileName("%sMapper");  // xml名
                })
                .templateEngine(new FreemarkerTemplateEngine())  // 使用 Freemaker 引擎模板，默认的是是Velocity引擎模板
                .execute();
    }
}
