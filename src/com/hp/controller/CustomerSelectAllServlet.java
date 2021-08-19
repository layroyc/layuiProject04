package com.hp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hp.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CustomerSelectAllServlet",urlPatterns = "/CustomerSelectAllServlet")
public class CustomerSelectAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.解决乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //2.接收参数
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String cust_name = req.getParameter("cust_name");
        String cust_company = req.getParameter("cust_company");
        String cust_position = req.getParameter("cust_position");
        String cust_phone = req.getParameter("cust_phone");
        String cust_birth = req.getParameter("cust_birth");
        String cust_sex = req.getParameter("cust_sex");
        String cust_desc = req.getParameter("cust_desc");
        String username = req.getParameter("username");
        String create_time = req.getParameter("create_time");
        String modify_time = req.getParameter("modify_time");
        Map paramMap = new HashMap();
        paramMap.put("page",page);
        paramMap.put("limit",limit);
        paramMap.put("cust_name",cust_name);
        paramMap.put("cust_company",cust_company);
        paramMap.put("cust_position",cust_position);
        paramMap.put("cust_phone",cust_phone);
        paramMap.put("cust_birth",cust_birth);
        paramMap.put("cust_sex",cust_sex);
        paramMap.put("cust_desc",cust_desc);
        paramMap.put("username",username);
        paramMap.put("create_time",create_time);
        paramMap.put("modify_time",modify_time);


        CustomerService service = new CustomerService();
        Map map = service.selectAllByParam(paramMap);

        PrintWriter writer = resp.getWriter();
        String s = JSONObject.toJSONString(map);
        writer.println(s);
        writer.close();
    }
}
