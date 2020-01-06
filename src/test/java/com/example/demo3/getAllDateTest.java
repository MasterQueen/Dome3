package com.example.demo3;

import com.alibaba.fastjson.JSONObject;
import com.example.demo3.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class getAllDateTest  {

    @Autowired
    UserMapper userMapper;
    @Test
    public JSONObject getAllDate() {

        JSONObject result = (JSONObject) JSONObject.toJSON(userMapper.getAllData());

         System.out.println(result);

        return null;
    }
}
