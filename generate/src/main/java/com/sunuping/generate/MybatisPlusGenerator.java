package com.sunuping.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author user
 * @date 2018/6/1
 */
public class MybatisPlusGenerator {

    public static void gen(MybatisplusCodeGeneratorConfig config, String[] tables) {
        if (tables == null || tables.length == 0) {
            return;
        }
        for (String table : tables) {
            String[] tmp = new String[1];
            tmp[0] = table;
            gen0(config, tmp);
        }
    }

    private static void gen0(MybatisplusCodeGeneratorConfig config, String[] tables) {
        if (tables == null || tables.length == 0) {
            return;
        }
        AutoGenerator gen = new AutoGenerator();
        /**
         * 全局配置
         */
        gen.setGlobalConfig(new GlobalConfig()
                .setOutputDir(config.getGenSrc() + "/src/main/java")
                .setFileOverride(true)
                .setActiveRecord(false)
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setOpen(false)
                .setAuthor(config.getAuthor())
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setEntityName("%s")
                .setIdType(IdType.AUTO)
                .setSwagger2(true)
        );

        /**
         * 数据库配置
         */
        gen.setDataSource(new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setDriverName(config.getDriverClassName())
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        if (fieldType.toLowerCase().contains("tinyint")) {
                            return DbColumnType.BOOLEAN;
                        }
                        if (fieldType.toLowerCase().contains("datetime")) {
                            return DbColumnType.DATE;
                        }
                        if (fieldType.toLowerCase().contains("timestamp")) {
                            return DbColumnType.DATE;
                        }
                        if (fieldType.toLowerCase().contains("date")) {
                            return DbColumnType.DATE;
                        }
                        return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
                    }
                })
                .setUrl(config.getUrl())
                .setUsername(config.getUsername())
                .setPassword(config.getPassword()));

        /**
         * 策略配置
         */
        gen.setStrategy(new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tables)
                .setEntityLombokModel(true)
                .setEntityBooleanColumnRemoveIsPrefix(false)
                //去掉前缀
                .setTablePrefix("t_","g_","u_")
        );

        /**
         * 包配置
         */
        gen.setPackageInfo(new PackageConfig()
                .setParent(config.getBasePackage())
                .setEntity(config.getEntityPackage())
                .setMapper(config.getMapperPackage())
                .setService(config.getServicePackage())
                .setServiceImpl(config.getServiceImplPackage())
                .setXml("com/sunuping/mapper")
        );

        /**
         * 注入自定义配置
         */
        InjectionConfig abc = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                List<TableInfo> tableInfos = this.getConfig().getTableInfoList();
                String realClassName = config.getBasePackage() + ".dataobject." + tableInfos.get(0).getEntityName();
                map.put("seriableId", Solution.myAutoNumber(realClassName).toString() + "L");
                this.setMap(map);
            }
        };
        /**
         * 自定义文件输出位置（非必须）
         */
        List<FileOutConfig> fileOutList = new ArrayList<>();
        fileOutList.add(new FileOutConfig(MybatisplusCodeGeneratorConfig.getTemplatePath()) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return config.getGenSrc() + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        abc.setFileOutConfigList(fileOutList);
        gen.setCfg(abc);
        /**
         * 指定模板引擎 默认是VelocityTemplateEngine ，需要引入相关引擎依赖
         */
        gen.setTemplateEngine(new FreemarkerTemplateEngine());

        /**
         * 模板配置
         */
        gen.setTemplate(new TemplateConfig()
                .setXml(null)
                //.setService(null)
                //.setServiceImpl(null)
                .setController(null));
        /**
         * 执行生成
         */
        gen.execute();
    }
}