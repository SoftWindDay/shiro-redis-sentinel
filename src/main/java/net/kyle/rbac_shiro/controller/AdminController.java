package net.kyle.rbac_shiro.controller;


import net.kyle.rbac_shiro.domain.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {


    @RequestMapping("/video/order")
    public JsonData findMyPlayRecord(){

        Map<String ,String> recordMap = new HashMap<>();

        recordMap.put("盗梦空间","剪辑成功300元");
        recordMap.put("复仇者联盟","877元");
        recordMap.put("肖生克的救赎","990元");

        return JsonData.buildSuccess(recordMap);

    }

}
