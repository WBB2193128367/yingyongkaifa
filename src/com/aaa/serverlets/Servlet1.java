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
import java.util.List;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
String user=request.getParameter("user");
String pwd=request.getParameter("pwd");
String pwd1=request.getParameter("pwd1");
        Yonghu yonghu = new Yonghu(user, pwd);
        Yonghu list=Caozuo.query(yonghu);


if(!pwd.equals("")&&!pwd1.equals("")&&!user.equals("")&&pwd.equals(pwd1)&&list==null) {
    Caozuo.insert(yonghu);
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    out.println(1);
}
else if(pwd.equals("")||pwd1.equals("")||user.equals("")){
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    out.println(2);
}

else if(list!=null){
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    out.println(3);
}
else if(list==null&&!pwd.equals(pwd1)){
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    out.println(4);
}
else{
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    out.println(5);
}

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
