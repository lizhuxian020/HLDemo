

# HLDemo: 25-3-12

##待解决问题:
1. 统一收集错误, 统一处理返回 3-12
   1. 关键类: ExceptionControllerAdvice 3-20
   2. 注解RestControllerAdvice, ExceptionHandler
   3. 见解: 原理, 使用AOP思想, 对各个Controller(target)的方法(pointCut)进行增强(Advice)
      1. 在这些方法执行的时候, 如果抛出异常了, 正好是被ExceptionHandler指定的, 就到Advice这里处理
2. User模块, 访问不到接口??  3-12
    1. ApplicationLauncher不能单独放一个文件夹里, 要放到最外层, 不然扫描不到 3.17
3. 如何使用注解给Controller入参做前置判断
4. 如何抛出异常 3-19
   1. 如果抛的是RuntimeException, 则在方法名上不用声明异常抛出 3-20

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

##学习
1. 使用lambaQuery, 要加泛型

###3-20
1. 新建自己的异常类型, 并实现全局捕获
2. 成功处理账号重复异常, 返回异常处理后的结果 (没处理, 则是架构自己处理的格式.)