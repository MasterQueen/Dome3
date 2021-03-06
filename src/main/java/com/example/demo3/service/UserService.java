package com.example.demo3.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo3.entry.User;

import java.util.Map;

public interface UserService {


    /**
     * 根据ID获取User
     * @param id
     * @return
     */
    User getUserByID(int id);

    /**
     * 更新User信息
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 添加User
     * @param user
     * @return
     */
    boolean insertUser(User user);

    /**
     * 删除User
     * @param id
     * @return
     */
    boolean deleteUser(int id);

    /**
     * 获取所有后台数据
     * @return
     */
    Map getAllDate();

}
