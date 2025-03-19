package cn.hl.user.dao;

import cn.hl.user.model.entity.UserAccountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginDao extends BaseMapper<UserAccountEntity> {
}
