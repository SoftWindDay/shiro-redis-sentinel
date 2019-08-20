package net.kyle.rbac_shiro.controller;


import net.kyle.rbac_shiro.domain.JsonData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("authc")
public class OrderController {


    @RequestMapping("/video/play_record")
    public JsonData findMyPlayRecord(){
        Subject subject = SecurityUtils.getSubject();
        Object o=subject.getPrincipal();
        Map<String ,Object> recordMap = new HashMap<>();

        recordMap.put("盗梦空间","剪辑成功300元");
        recordMap.put("复仇者联盟","877元");
        recordMap.put("肖生克的救赎","990元");

        recordMap.put("用户名",o);
        return JsonData.buildSuccess(recordMap);

    }

}
