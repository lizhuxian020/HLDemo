# 房屋管理

1. 有客户进场
   1. 录入楼栋信息: 名称, 地址, 房东id, 水费, 电费, 物业费, 描述, 村, 区, 楼层, 是否带电梯
   2. 录入楼栋内的房间: 名称, 租金, 面积, 描述, 所在楼层, 房号, 

SQL建表
building_info: id, name, address, ownerId(UserId in user_account), water_bill, electric_bill, property_fee, description
room_info: id, name, rent, area, description
building_room_ref: id, buildingId, roomId