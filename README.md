

# HLDemo: 25-3-12

##待解决问题:
1. 统一收集错误, 统一处理返回 3-12
2. User模块, 访问不到接口??  3-12
    1. ApplicationLauncher不能单独放一个文件夹里, 要放到最外层, 不然扫描不到 3.17
3.

##进度:
1. 创建demo, 生成base, main, user模块, 3-12
2. 登录接口: 生成token 3-17
3. 注册账号, 使用MySql数据库 3-19
4. redis缓存机制, 缓存token, 实现token有效期
5. Web拦截器, 校验token


##日志:
###3-19: 
1. 注册账号
2. 新建sql表
3. 引入模块:mybatis-plus, mysql
4. 决策: baseModule引用所有第三方库, 和使用. 其他模块只写业务
5. 学习: 
   1. Dao要使用@Mapper注解
6. 成功:
   1. 成功insert语句
7. 问题:
   1. 没办法通过lambdaQuery查询