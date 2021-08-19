package com.hp.service;

import com.hp.bean.Customer;
import com.hp.dao.CustomerDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    //全查
    public Map selectAllByParam(Map map){
        CustomerDao dao = new CustomerDao();
        List<Map> maps = dao.selectAllByParam(map);
        HashMap codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","ok");
        codeMap.put("data",maps);
        Map countMap = selectAllByParamCount(map);
        int count = (int) countMap.get("data");
        codeMap.put("count",count);
        return codeMap;
    }

    //全查总条数  多表
    public Map selectAllByParamCount(Map map){
        Map codeMap = new HashMap();
        CustomerDao dao = new CustomerDao();
        int i = dao.selectAllParamCount(map);
        codeMap.put("code",0);
        codeMap.put("msg","ok");
        codeMap.put("data",i);
        return codeMap;
    }

    //添加
    public Map insertCustomer(Customer customer){
        System.out.println("进入到 insertCustomer");
        Map map = new HashMap();
        CustomerDao customerDao = new CustomerDao();
        System.out.println("customerDao = " + customerDao);
        int i = customerDao.insertCustomer(customer);
        System.out.println("i = " + i);
        if(i==1){
            map.put("code",0);
            map.put("msg","添加成功");
        }else{
            map.put("code",4001);
            map.put("msg","添加不成功");
        }
        return map;
    }

    //删除
    public Map delCustomer(Customer customer){
        Map codeMap = new HashMap();
        CustomerDao dao = new CustomerDao();
        int i = dao.delCustomer(customer);
        codeMap.put("code",0);
        codeMap.put("msg","ok");
        codeMap.put("data",i);
        return codeMap;
    }
}
