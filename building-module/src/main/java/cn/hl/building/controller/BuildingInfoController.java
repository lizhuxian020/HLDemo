package cn.hl.building.controller;


import cn.hl.building.model.dto.BuildingInfoPageDTO;
import cn.hl.building.model.dto.BuildingInfoSaveDTO;
import cn.hl.building.service.BuildingInfoService;
import cn.hl.common.model.CallResult;
import cn.hl.common.model.jwt.TokenMessage;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/buildingInfo")
public class BuildingInfoController {

    @Resource
    private BuildingInfoService infoService;

    @GetMapping("/{buildingId}")
    public String getById(@PathVariable int buildingId, TokenMessage tokenMessage) {
        return JSON.toJSONString(tokenMessage);
//        return String.valueOf(buildingId);
    }

    @PostMapping("/save")
    public CallResult save(@RequestBody BuildingInfoSaveDTO saveDTO) {
        return CallResult.successBool(infoService.saveInfo(saveDTO));
    }

    @PostMapping("/update")
    public CallResult update(@RequestBody BuildingInfoSaveDTO updateDTO) {
        return CallResult.successBool(infoService.updateInfo(updateDTO));
    }

    @PostMapping("/list")
    public CallResult list(@RequestBody BuildingInfoPageDTO pageDTO) {
        return CallResult.success(infoService.listBuildingInfo(pageDTO));
    }

    @DeleteMapping("/delete")
    public CallResult delte(@RequestBody BuildingInfoSaveDTO deleteDto) {
        return CallResult.successBool(infoService.deleteById(deleteDto));
    }

    @GetMapping("/id/{id}")
    public CallResult getById(@PathVariable int id) {
        return CallResult.success(infoService.infoWithId(id));
    }



}
