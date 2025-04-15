package cn.hl.building.controller;


import cn.hl.common.model.jwt.TokenMessage;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buildingInfo")
public class BuildingInfoController {

    @GetMapping("/{buildingId}")
    public String getById(@PathVariable int buildingId, TokenMessage tokenMessage) {
        return JSON.toJSONString(tokenMessage);
//        return String.valueOf(buildingId);
    }

}
