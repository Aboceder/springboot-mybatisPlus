package com.demo.mybatisplus;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * mybatis-plus代码生成器
 */
@SpringBootTest(classes = {CodeGeneratorTest.class})
public class CodeGeneratorTest {

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    private static final String JAVA_DIR = "/Users/bopomofo/project/mybatisPlus/src/main/java";
    private static final String PACKAGE = "com.demo";
    private static final String MAPPER_XML_DIR = "/Users/bopomofo/project/mybatisPlus/src/main/resources/mapper/school";

    @Test
    public void generationTest() {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)                           // 配置数据源
                .globalConfig(builder -> {
                    builder.author("Aboceder")                                      // 作者
//                          .enableSwagger()                                        // 启用swagger注解
//                          .enableSpringdoc()                                      // 启用spring-doc
                            .dateType(DateType.TIME_PACK)                           // 配置时间映射类型
                            .disableOpenDir()                                       // 生成后不打开资源管理器
                            .outputDir(JAVA_DIR);                                   // 输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(PACKAGE)                                         // 父包名
                            .moduleName("school")                                   // 模块对应名称
                            .pathInfo(Collections.singletonMap(OutputFile.xml, MAPPER_XML_DIR))  //这个是设置你各个层的输出目录
                            .entity("entity.po")                                     // 设置生成的包名，默认是entity
                            .service("service")                                     // 同上
                            .serviceImpl("service.impl")                            // 同上
                            .controller("controller");                              // 同上
                })
                .strategyConfig(builder -> {
                    builder
                            .addInclude("student","class")                                     // 默认是会为所有表生成，设置这个可以自定义生成哪些表
//                          .addTablePrefix("ums_", "sms_", "pms_", "oms_", "cms_") //忽略表明前缀
                            // Domain配置
                            .entityBuilder()
                            .enableFileOverride()                                   // 这个是当文件存在时覆盖原文件
                            .enableLombok()                                         // 启用lombok，给实体类加Getter，Setter注解
                            .enableChainModel()                                     // @Accesor（chain=true）注解
                            .enableTableFieldAnnotation()                           // @TableField注解
                            // Controller配置
                            .controllerBuilder()
                            .enableFileOverride()
                            .enableRestStyle()                                      // @RestController
                            // Service配置
                            .serviceBuilder()
                            .enableFileOverride()
                            .formatServiceFileName("%sService")                     // 自定义Service层接口名称，默认是"I+表明+Service"
                            .formatServiceImplFileName("%sServiceImpl")             // 实现类的名称，默认表名+Impl
                            // Mapper配置
                            .mapperBuilder()
                            .enableFileOverride()
                            .enableMapperAnnotation()                               // 开启@mapper注解
                            // .enableBaseColumnList()                                 // mapper.xml中会生成包含全列的sql模板
                            .enableBaseResultMap();                                 // resultMap
                })
                // 模板引擎配置
                .templateEngine(new FreemarkerTemplateEngine())                     // 这里采用freemaker引擎，感觉无所谓
/*                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER)                        //不生成controller层
                            .disable(TemplateType.SERVICE_IMPL);                    //不生成service层的实现类
                })*/
                .execute();                                                         //执行
    }


}