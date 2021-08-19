package com.hp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hp.bean.User;
import com.hp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "UserInsertServlet",urlPatterns = "/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.解决乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("utf-8");

        //2.收参数
        String username = req.getParameter("username");
        String real_name = req.getParameter("real_name");
        String password = req.getParameter("password");
        String img = req.getParameter("img");
        String type = req.getParameter("type");
        String is_del = req.getParameter("is_del");
        String create_time = req.getParameter("create_time");
        String modify_time = req.getParameter("modify_time");


        //把接收到的参数封装到 map中
        User user = new User();
        System.out.println("user = " + user);
        user.setUsername(username);
        user.setReal_name(real_name);
        user.setPassword(password);
        user.setImg(img);
        String typess=(type.equals("管理员")?"1":"2");
        user.setType(Integer.parseInt(typess));
        user.setIs_del(Integer.parseInt(is_del));
        user.setCreate_time(create_time);
        user.setModify_time(modify_time);

        System.out.println("这是user = " + user);
        //调用 service 层
        UserService userService = new UserService();
        Map map = userService.insertUser(user);
        System.out.println("map = " + map);
        //4.把map 变成json
        String s = JSONObject.toJSONString(map);
        System.out.println("s = " + s);
        //5.使用 流输出
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();



    }
}
