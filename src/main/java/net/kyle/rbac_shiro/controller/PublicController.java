package net.kyle.rbac_shiro.controller;

import net.kyle.rbac_shiro.domain.UserQuery;
import net.kyle.rbac_shiro.domain.JsonData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pub")
public class PublicController {


    @RequestMapping("need_login")
    public JsonData needLogin(){

        return JsonData.buildSuccess("温馨提示：请使用对应的账号登录",-2);

    }


    @RequestMapping("not_permit")
    public JsonData notPermit(){

        return JsonData.buildSuccess("温馨提示：拒绝访问，没权限",-3);
    }


    @RequestMapping("index")
    public JsonData index(){

        List<String> videoList = new ArrayList<>();
        videoList.add("爱的修养");
        videoList.add("人与自然");
        videoList.add("傲慢与偏见");
        videoList.add("redis集群");
        videoList.add("zookeeper");

        return JsonData.buildSuccess(videoList);

    }


    /**
     * 登录接口
     * @param userQuery
     * @param request
     * @param response
     * @return
     */
    @GetMapping("login")
    public JsonData login(UserQuery userQuery, HttpServletRequest request, HttpServletResponse response){

        Subject subject = SecurityUtils.getSubject();
        Map<String,Object> info = new HashMap<>();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userQuery.getName(), userQuery.getPwd());

            subject.login(usernamePasswordToken);

            info.put("msg","登录成功");
            info.put("session_id", subject.getSession().getId());

            return JsonData.buildSuccess(info);

        }catch (Exception e){
            e.printStackTrace();

            return JsonData.buildError("账号或者密码错误");

        }


    }




}
