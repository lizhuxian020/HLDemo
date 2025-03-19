package cn.hl.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_account")
public class UserAccountEntity {

    private String account;
    private String password;

}
