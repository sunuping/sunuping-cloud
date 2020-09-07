package com.sunuping.generate;


import cn.hutool.setting.dialect.Props;

import java.util.Objects;

/**
 * @author user
 * Copyright (C) 2016-2019 All Rights Reserved.
 */
public class GeneratorApplication {

    public static void main(String[] args) {

        Props jdbcProps = new Props("classpath:jdbc.properties");
        Props generatorProps = new Props("classpath:generate.properties");

        MybatisplusCodeGeneratorConfig generatorConfig = new MybatisplusCodeGeneratorConfig();
        generatorConfig.setDriverClassName(jdbcProps.getProperty("jdbc.driverClassName"));
        generatorConfig.setUrl(jdbcProps.getProperty("jdbc.url"));
        generatorConfig.setUsername(jdbcProps.getProperty("jdbc.username"));
        generatorConfig.setPassword(jdbcProps.getProperty("jdbc.password"));

        generatorConfig.setBasePackage(generatorProps.getProperty("base.package"));
        generatorConfig.setEntityPackage(generatorProps.getProperty("entity.package"));
        generatorConfig.setServicePackage(generatorProps.getProperty("service.package"));
        generatorConfig.setServiceImplPackage(generatorProps.getProperty("serviceImpl.package"));
        generatorConfig.setMapperPackage(generatorProps.getProperty("mapper.package"));

        generatorConfig.setAuthor(generatorProps.getProperty("author"));
        generatorConfig.setProjectName(generatorProps.getProperty("project.name"));
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        if (path.contains(generatorConfig.getProjectName())) {
//            path = path.substring(0, path.indexOf(generatorConfig.getProjectName()) + generatorConfig.getProjectName().length());


            path = path.substring(1, path.length() - 1);
            path = path.replace("/target/classes", "");
            generatorConfig.setGenSrc(path);
        }
        if (generatorConfig.getGenSrc() == null) {
            System.err.println("没有找到生成路径");
            return;
        }
        String tableStr = "ums_admin, ums_admin_login_log, ums_admin_permission_relation, ums_admin_role_relation, ums_growth_change_history, ums_integration_change_history, ums_integration_consume_setting, ums_member, ums_member_level, ums_member_login_log, ums_member_member_tag_relation, ums_member_product_category_relation, ums_member_receive_address, ums_member_rule_setting, ums_member_statistics_info, ums_member_tag, ums_member_task, ums_menu, ums_permission, ums_resource, ums_resource_category, ums_role, ums_role_menu_relation, ums_role_permission_relation, ums_role_resource_relation";
        tableStr="t_user,t_user_auth";
        //要生成的表名
        String[] tables = tableStr.replaceAll(" ","").split(",");

        //执行
        MybatisPlusGenerator.gen(generatorConfig, tables);
    }
}
