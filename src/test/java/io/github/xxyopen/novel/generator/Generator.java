package io.github.xxyopen.novel.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://zhuanlan.zhihu.com/p/489218349
// https://blog.csdn.net/watson2017/article/details/125684134
public class Generator {



    public static void main(String[] args) {
        System.out.println(System.getenv().get("USER"));
        genCode("book_comment");
    }

    private static void genCode(String tables) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/novel?useUnicode=true&chatacterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true","root","123456")
                .globalConfig(builder -> {
                    builder.author("lxx")
                            .commentDate("yyyy/MM/dd")
                            .fileOverride()
                            .disableOpenDir()
                            .outputDir(System.getProperty("user.dir") + "/src/main/java");
                })
                .packageConfig(builder -> {
                    builder.parent("io.github.xxyopen.novel")
                            .entity("dao.entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("dao.mapper")
                            .controller("controller.author")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper"));

                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.SERVICE)
                            .disable(TemplateType.SERVICEIMPL)
                            .disable(TemplateType.CONTROLLER);
                })
                .strategyConfig(builder -> builder.addInclude(getTables(tables))
                        .controllerBuilder()
                        .enableRestStyle()
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
//                        .mapperBuilder()
//                        .enableBaseResultMap()
//                        .enableBaseColumnList()
                )
                .execute();
    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
