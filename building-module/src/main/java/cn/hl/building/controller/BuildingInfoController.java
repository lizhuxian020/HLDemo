package cn.hl.building.controller;


import cn.hl.common.model.jwt.TokenMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buildingInfo")
public class BuildingInfoController {

    @GetMapping("/{buildingId}")
    public String getById(@PathVariable int buildingId, TokenMessage tokenMessage) {
        return String.valueOf(buildingId);
    }
}
