package com.example.demo3.mapper;

import com.example.demo3.entry.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User数据操作
 */
@Component
public interface UserMapper {

    /**
     * 根据ID获取
     * @param id
     * @return
     */
   User getUserByID(int id);

    /**
     * 获取全部
     * @return
     */
   List<User> getAllUser();

    /**
     * 插入user
     * @param user
     * @return
     */
   int insterUser(User user);

}
