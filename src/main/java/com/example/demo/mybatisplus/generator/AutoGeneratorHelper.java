package com.example.demo.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * @author wxq
 * @date 2018-10-31
 */
public class AutoGeneratorHelper {


    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mybatisgenerator");

        AutoGenerator generator = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(resourceBundle.getString("global.output"));
        //active record意思是实体继承Model，比如User继承Model后，可以操作user.insert,user.updateById,实体必须有唯一主键
        gc.setActiveRecord(false);
        gc.setFileOverride(true);
        gc.setEnableCache(false);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setDateType(DateType.ONLY_DATE);//生成的时间类型只用Date
        gc.setAuthor(resourceBundle.getString("global.author"));

        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sDao");
        gc.setEntityName("%sENT");
        gc.setXmlName("%sMapper");
        generator.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName(resourceBundle.getString("datasource.drivername"));
        dsc.setUsername(resourceBundle.getString("datasource.username"));
        dsc.setPassword(resourceBundle.getString("datasource.password"));
        dsc.setUrl(resourceBundle.getString("datasource.url"));
        generator.setDataSource(dsc);

        //生成实体策略信息
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("rp_card");
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setFieldPrefix(resourceBundle.getString("strategy.fieldPrefix").split(","));
        sc.entityTableFieldAnnotationEnable(true);//设置字段注解
        sc.setRestControllerStyle(true);
        generator.setStrategy(sc);

        //生成包信息
        PackageConfig pc = new PackageConfig();
        pc.setParent(resourceBundle.getString("package.parent"));
        generator.setPackageInfo(pc);


        /**
         * 注入自己生成的信息
         */
//        inject(generator);


        // 关闭默认 xml 生成，调整生成 至 根目录
        /*TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        mpg.setTemplate(tc);*/

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        /*TemplateConfig tc = new TemplateConfig();
        tc.setController("/templatesMybatis/controller.java.vm");
        tc.setService("/templatesMybatis/service.java.vm");
        tc.setServiceImpl("/templatesMybatis/serviceImpl.java.vm");
        tc.setEntity("/templatesMybatis/entity.java.vm");
        tc.setMapper("/templatesMybatis/mapper.java.vm");
        tc.setXml("/templatesMybatis/mapper.xml.vm");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        generator.setTemplate(tc);*/

        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    private static void inject(AutoGenerator generator) {
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】  ${cfg.abc}
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // 自定义 xxListIndex.html 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templatesMybatis/list.html.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return "E://test//html//" + tableInfo.getEntityName() + "ListIndex.html";
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);

        // 自定义  xxAdd.html 生成
        focList.add(new FileOutConfig("/templatesMybatis/add.html.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return "E://test//html//" + tableInfo.getEntityName() + "Add.html";
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);

        //  自定义 xxUpdate.html生成
        focList.add(new FileOutConfig("/templatesMybatis/update.html.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return "E://test//html//" + tableInfo.getEntityName() + "Update.html";
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);
    }

}
