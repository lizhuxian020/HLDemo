package cn.hl.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_account")
public class UserAccountEntity {

    @TableId(value = "user_id")
    private int userId;
    private String account;
    private String password;
    private String realName;
}
