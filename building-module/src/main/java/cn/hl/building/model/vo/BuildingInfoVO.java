package cn.hl.building.model.vo;

import lombok.Data;

@Data
public class BuildingInfoVO {
    private int buildingId;
    private String name;
    private String address;
    private String ownerName;
    private float waterBill;
    private float electricBill;
    private float propertyFee;
    private String description;
    private String villageName;
    private String regionName;
    private int totalFloor;
    private int elevator;
}
