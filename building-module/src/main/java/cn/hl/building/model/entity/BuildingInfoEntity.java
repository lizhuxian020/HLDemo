package cn.hl.building.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("building_info")
public class BuildingInfoEntity {

    /*
    这里需要注明id, 这样baseMapper的时候, 就可以直接用SelectById了. 不然只能自己写wrapper
     */
    @TableId("building_id")
    private int buildingId;
    private String name;
    private String address;
    private int ownerId;
    private float waterBill;
    private float electricBill;
    private float propertyFee;
    private String description;
    private String villageName;
    private String regionName;
    private int totalFloor;
    private int elevator;
    private int isDeleted;
}
