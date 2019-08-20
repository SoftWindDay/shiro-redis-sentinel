package net.kyle.rbac_shiro.controller;


import net.kyle.rbac_shiro.domain.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("video")
public class VideoController {


    @RequestMapping("/update")
    public JsonData updateVideo(){

        return JsonData.buildSuccess("video更新成功");

    }

}
