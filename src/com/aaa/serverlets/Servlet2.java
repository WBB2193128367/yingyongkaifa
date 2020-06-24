package com.aaa.serverlets;

import com.aaa.Userbean.Yonghu;
import com.aaa.caozuos.Caozuo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String user=request.getParameter("user");
        String pwd=request.getParameter("pwd");
        System.out.println(user);
        System.out.println(pwd);
        Yonghu yonghu = new Yonghu(user, pwd);
        Yonghu list= Caozuo.query(yonghu);


        if(list==null&&!pwd.equals("")&&!user.equals("")){
            System.out.println("用户不存在");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(4);

        }
        else if(list!=null&&pwd.equals(list.getPwd())){
            System.out.println("登录成功");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(1);
        }
        else if(user.equals("") || pwd.equals("")){
            System.out.println("账号或密码不能为空");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(2);
        }
        else if(list!=null&&!pwd.equals(list.getPwd())){
            System.out.println("密码错误");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(3);

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
