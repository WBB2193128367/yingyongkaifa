package com.aaa.caozuos;

import com.aaa.Userbean.Yonghu;
import com.aaa.dbcp.Lianjie;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class Caozuo {
    private  static QueryRunner qr=new QueryRunner(Lianjie.getDataSource());


    public static void insert(Yonghu yonghu ){
      String sql= "insert into users(user,pwd) values(?,?)" ;
      Object[] params={yonghu.getUser(),yonghu.getPwd()};
      int t=0;
        try {
            t=qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static Yonghu query(Yonghu yonghu){

        String sql ="select * from users where user = ?";
        Object params= yonghu.getUser();
        try {
          Yonghu list=qr.query(sql,new BeanHandler<Yonghu>(Yonghu.class),params);
          //System.out.println(list);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }

    public static List<Yonghu> query(){
        List<Yonghu> list;
        String sql ="select * from users";
        try {
            list=qr.query(sql,new BeanListHandler<Yonghu>(Yonghu.class));
            //System.out.println(list);

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
