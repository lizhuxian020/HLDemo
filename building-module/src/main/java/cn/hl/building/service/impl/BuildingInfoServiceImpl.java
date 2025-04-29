package cn.hl.building.service.impl;

import cn.hl.building.dao.BuildingInfoDao;
import cn.hl.building.model.dto.BuildingInfoPageDTO;
import cn.hl.building.model.dto.BuildingInfoSaveDTO;
import cn.hl.building.model.entity.BuildingInfoEntity;
import cn.hl.building.model.vo.BuildingInfoVO;
import cn.hl.building.service.BuildingInfoService;
import cn.hl.user.dao.UserAccountDao;
import cn.hl.user.model.entity.UserAccountEntity;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BuildingInfoServiceImpl extends ServiceImpl<BuildingInfoDao, BuildingInfoEntity> implements BuildingInfoService {

    @Resource
    private UserAccountDao userAccountDao;

    @Override
    public boolean saveInfo(BuildingInfoSaveDTO saveDTO) {
        BuildingInfoEntity entity = new BuildingInfoEntity();
        BeanUtil.copyProperties(saveDTO, entity);
        this.baseMapper.insert(entity);
        return true;
    }

    @Override
    public IPage<BuildingInfoVO> listBuildingInfo(BuildingInfoPageDTO pageDTO) {
        Page<BuildingInfoVO> page = new Page(pageDTO.getCurrent(), pageDTO.getSize());
        IPage<BuildingInfoEntity> iPage = this.baseMapper.listBuildingInfo(page);
        ArrayList<BuildingInfoVO> arrayList = new ArrayList<BuildingInfoVO>();
        for (BuildingInfoEntity buildingInfo : iPage.getRecords()) {
            BuildingInfoVO vo = new BuildingInfoVO();
            BeanUtil.copyProperties(buildingInfo, vo);
            UserAccountEntity entity = this.userAccountDao.selectOne(new LambdaQueryWrapper<UserAccountEntity>().eq(UserAccountEntity::getUserId, buildingInfo.getOwnerId()));
            vo.setOwnerName(entity.getRealName());
            arrayList.add(vo);
        }
        page.setRecords(arrayList);
        long pages = page.getPages();
        System.out.println("pages" + pages);
        return page;
    }

    @Override
    public BuildingInfoEntity infoWithId(int id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public Boolean updateInfo(BuildingInfoSaveDTO updateDTO) {
        BuildingInfoEntity entity = new BuildingInfoEntity();
        BeanUtil.copyProperties(updateDTO, entity);
        this.baseMapper.updateById(entity);
        return true;
    }

    @Override
    public Boolean deleteById(BuildingInfoSaveDTO deleteDto) {
        BuildingInfoEntity entity = new BuildingInfoEntity();
        deleteDto.setIsDeleted(1);
        BeanUtil.copyProperties(deleteDto, entity);
        this.baseMapper.updateById(entity);
        return true;
    }
}
