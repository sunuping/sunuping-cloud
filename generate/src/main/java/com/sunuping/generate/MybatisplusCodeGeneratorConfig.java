package com.sunuping.generate;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author user
 * @description: 代码生成器，使用的是 mybatis-plus提供的代码生成器，默认使用freemarker 模板，需要依赖 freemarker jar
 **/

public class MybatisplusCodeGeneratorConfig {

    private static final String templatePath = "/templates/mapper.xml.ftl";

    private String driverClassName;
    private String url;
    private String username;
    private String password;


    private String basePackage;
    private String entityPackage;
    private String servicePackage;
    private String serviceImplPackage;
    private String mapperPackage;

    private String author;

    private String projectName;

    private String genSrc;

    public static String getTemplatePath() {
        return templatePath;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getGenSrc() {
        return genSrc;
    }

    public void setGenSrc(String genSrc) {
        this.genSrc = genSrc;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getServiceImplPackage() {
        return serviceImplPackage;
    }

    public void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
