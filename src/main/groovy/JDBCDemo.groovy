package main.groovy

import groovy.sql.Sql

class JDBCDemo {
    static void main(args) {
        List<String> list = new ArrayList<>();
        list.add("aaa")
        list.add("bbb")
        println list;

        def map = ['x' : 1,'y' : 4]
        map.put('z',3)
        println map

        //Sql.newInstance(String url, String user, String password, String driverClassName)
        //传入的几个参数基本就是原来jdbc.properities里面的配置文件的内容，我用的是mysql，由于保密性，不方便透露，大家可以使用自己的mysql数据库地址，用户名和密码；
        //String driverClassName="com.mysql.jdbc.Driver"这个是可以透露给大家的，哈哈
//        Sql sql = Sql.newInstance("jdbc:mysql://**.mysql.rds.aliyuncs.com:3306/**?useUnicode=true&characterEncoding=UTF-8", "uesr", "password", "com.mysql.jdbc.Driver");
//
//        sql.eachRow("select * from sys_t_user") {
//            println it.id + ":" + it.name
//        }
    }
}
