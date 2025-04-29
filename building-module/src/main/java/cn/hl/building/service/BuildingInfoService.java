package cn.hl.building.service;

import cn.hl.building.model.dto.BuildingInfoPageDTO;
import cn.hl.building.model.dto.BuildingInfoSaveDTO;
import cn.hl.building.model.entity.BuildingInfoEntity;
import cn.hl.building.model.vo.BuildingInfoVO;
import cn.hl.common.model.CallResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BuildingInfoService extends IService<BuildingInfoEntity> {
    boolean saveInfo(BuildingInfoSaveDTO saveDTO);

    IPage<BuildingInfoVO> listBuildingInfo(BuildingInfoPageDTO pageDTO);

    BuildingInfoEntity infoWithId(int id);

    Boolean updateInfo(BuildingInfoSaveDTO updateDTO);

    Boolean deleteById(BuildingInfoSaveDTO deleteDto);
}
