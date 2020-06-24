package com.aaa.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class Lianjie {
    //创建DataSource接口的实现类对象

    private static BasicDataSource dataSource=new BasicDataSource();
    static
    {
        //必须配的，数据库驱动，连接地址，用户名，密码
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/wbb1?charactorEncoding=utf8&useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("wbb091824");
        //可以不配置的，会有默认值
        dataSource.setInitialSize(10); //初始创建的连接数
        dataSource.setMaxTotal(10); //最大连接数量，也就是一共有多少个连接，包括使用着的和空闲的
        dataSource.setMaxIdle(5); //最大空闲数，表示没有连接的时候，最多有5个连接不被回收
        dataSource.setMinIdle(2); //最小空闲数，表示没有连接的时候，最少有1个连接不会被回收
    }
    public static DataSource getDataSource()
    {
        return dataSource;
    }

}