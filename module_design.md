# 房屋管理

1. 有客户进场
   1. 录入楼栋信息: 名称, 地址, 房东id, 水费, 电费, 物业费, 描述, 村, 区, 楼层, 是否带电梯
   2. 录入楼栋内的房间: 名称, 租金, 面积, 描述, 所在楼层, 房号, 

SQL建表
building_info: id, name, address, ownerId(UserId in user_account), water_bill, electric_bill, property_fee, description
room_info: id, name, rent, area, description
building_room_ref: id, buildingId, roomId

4.30
1. 现已完成用户登录和楼栋增删改查
2. 未来要完成的事情:
   1. 在building模块下, 实现快速手工抄水电
   2. 实现快速录入房间信息
      1. 在房间录入页上, 下拉框指定楼栋, 和录入房间数, 展示对应几行房间表, 点击提交, 则一次性录入