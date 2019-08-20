package net.kyle.rbac_shiro.service.impl;

import net.kyle.rbac_shiro.dao.UserMapper;
import net.kyle.rbac_shiro.dao.RoleMapper;
import net.kyle.rbac_shiro.domain.Role;
import net.kyle.rbac_shiro.domain.User;
import net.kyle.rbac_shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findAllUserInfoByUsername(String username) {

        //业务方法里面加缓存，也可以

        User user = userMapper.findByUsername(username);

        //用户的角色集合
        List<Role> roleList =  roleMapper.findRoleListByUserId(user.getId());


        user.setRoleList(roleList);

        return user;
    }


    @Override
    public User findSimpleUserInfoById(int userId) {
        return userMapper.findById(userId);
    }


    @Override
    public User findSimpleUserInfoByUsername(String username) {
        return userMapper.findByUsername(username);
    }


}
