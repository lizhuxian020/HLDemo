package cn.hl.building.model.dto;


import lombok.Data;

@Data
public class BuildingInfoSaveDTO {

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
