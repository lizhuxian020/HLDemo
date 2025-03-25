#JAVA 项目用法

##在Controller里获取header字段
1. 直接在method上添加入参: HttpServletRequest request
2. 通过request拿到header, 再通过key拿到你想要的value