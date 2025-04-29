package cn.hl.building.dao;

import cn.hl.building.model.entity.BuildingInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BuildingInfoDao extends BaseMapper<BuildingInfoEntity> {
    /*
    在入参写入page, MP就会自动处理
     */
    IPage<BuildingInfoEntity> listBuildingInfo(@Param("page") Page page);
}
