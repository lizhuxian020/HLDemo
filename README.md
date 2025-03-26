

# HLDemo: 25-3-12

##待解决问题:
1. 统一收集错误, 统一处理返回 3-12
   1. 3-20
      1. 关键类: ExceptionControllerAdvice 
      2. 注解RestControllerAdvice, ExceptionHandler
      3. 见解: 原理, 使用AOP思想, 对各个Controller(target)的方法(pointCut)进行增强(Advice)
         1. 在这些方法执行的时候, 如果抛出异常了, 正好是被ExceptionHandler指定的, 就到Advice这里处理
2. User模块, 访问不到接口??  3-12
    1. ApplicationLauncher不能单独放一个文件夹里, 要放到最外层, 不然扫描不到 3.17
3. 如何使用注解给Controller入参做前置判断
4. 如何抛出异常 3-19
   1. 如果抛的是RuntimeException, 则在方法名上不用声明异常抛出 3-20
5. 如何抓取不是自定义以外的异常, 比如找不到路径404 3-24
6. 如何实现: login不需要token, 其他需要 3-24
   1. 3-26
      1. 在旧项目, 是通过shiro框架来实现(OAuthFilter), 新项目是通过webmvcInterceptor实现(LZMInterceptor)
      2. 逻辑上都是一样, 通过拦截所有的请求, 做前置AOP, 来处理该请求是否校验token

##总目标：实现水电记录，输出月账单，房屋房间管理。
##进度:
1. 创建demo, 生成base, main, user模块, 3-12
2. 登录接口: 生成token 3-17
3. 注册账号, 使用MySql数据库 3-19
4. redis缓存机制, 缓存token, 实现token有效期3-25
   5. 不使用redis来实现有效期，直接使用jjwt的封装来实现
5. Web拦截器, 校验token
6. 自家window环境搭建基本完成，实现Linux环境下，docker安装和MySQL的安装 3-25
7. 实现房屋管理，构思管理所需要功能，构思表结构。


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

##学习
1. 使用lambaQuery, 要加泛型

###3-20
1. 新建自己的异常类型, 并实现全局捕获
2. 成功处理账号重复异常, 返回异常处理后的结果 (没处理, 则是架构自己处理的格式.)

##3-24
1. 新建building模块, 准备实现接受token
2. 实现WebMvcConfigSupport, 实现参数解析器
3. 如何实现: login不需要token, 其他需要

##3-25
1. 基本完成jwt方案选择, 使用jjwt库, 来完成对jwt的使用
   1. jjwt可以设置过期时间, 不需要依赖redis
2. 基本完成jwtConfig

##3-26
1. 创建楼栋,房间的表
2. 了解shiro如何使用, 以解决接口是否需要校验token问题