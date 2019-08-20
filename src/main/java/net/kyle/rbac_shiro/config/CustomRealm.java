package net.kyle.rbac_shiro.config;

import net.kyle.rbac_shiro.domain.Permission;
import net.kyle.rbac_shiro.service.UserService;
import net.kyle.rbac_shiro.domain.Role;
import net.kyle.rbac_shiro.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义realm
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 进行权限校验的时候回调用
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权 doGetAuthorizationInfo");

        User newUser = (User)principals.getPrimaryPrincipal();
        User user = userService.findAllUserInfoByUsername(newUser.getUsername());

        List<String> stringRoleList = new ArrayList<>();
        List<String> stringPermissionList = new ArrayList<>();


        List<Role> roleList = user.getRoleList();

        for(Role role : roleList){
            stringRoleList.add(role.getName());

            List<Permission> permissionList = role.getPermissionList();

            for(Permission p: permissionList){
                if(p!=null){
                    stringPermissionList.add(p.getName());
                }
            }

        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(stringRoleList);
        simpleAuthorizationInfo.addStringPermissions(stringPermissionList);

        return simpleAuthorizationInfo;
    }









    /**
     * 用户登录的时候会调用
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("认证 doGetAuthenticationInfo");

        //从token获取用户信息，token代表用户输入
        String username = (String)token.getPrincipal();

        User user =  userService.findAllUserInfoByUsername(username);

        //取密码
        String pwd = user.getPassword();
        if(pwd == null || "".equals(pwd)){
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
