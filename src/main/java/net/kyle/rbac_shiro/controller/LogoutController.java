package net.kyle.rbac_shiro.controller;


import net.kyle.rbac_shiro.domain.JsonData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * logout, 映射shiro自带的过滤器
 */
@RestController
public class LogoutController {


    @RequestMapping("/logout")
    public JsonData findMyPlayRecord(){

        Subject subject = SecurityUtils.getSubject();

        if(subject.getPrincipals() != null ){

        }

        SecurityUtils.getSubject().logout();

        return JsonData.buildSuccess("logout成功");

    }

}
