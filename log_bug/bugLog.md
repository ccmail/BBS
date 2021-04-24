1.**已解决**第一个bug,创建SpringBoot,maven插件错误

    未找到插件 'org.springframework.boot:spring-boot-maven-plugin
    
    解决方式:加入版本号<version>2.4.5</version>/**2.4.5为ide推荐版本号,也是我选择的springboot版本**/
         <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.4.5</version>
         </plugin>

2.**已解决**第二个问题,引入bootstrap时下拉框无反应

    缺失jquery文件,bootstrap一系列操作需要加入jquery依赖才可实现
    
    解决方式:在引入bootstrap前先引入jquery文件
        <!--引入jquery文件 start-->
        <script src="../static/js/jquery-3.6.0.min.js"></script>
        <!--引入jquery文件 end-->
    
        <!--引入bootstrap文件 start-->
        <link rel="stylesheet" href="../static/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="../static/css/bootstrap.min.css">
        <script src="../static/js/bootstrap.min.js"></script>
        <!--引入bootstrap文件 end-->

3.**已解决**第三个问题,启动springboot报错

    Whitelabel Error Page
    This application has no explicit mapping for /error, so you are seeing this as a fallback.
    
    Wed Apr 21 22:20:50 CST 2021
    There was an unexpected error (type=Not Found, status=404).
    
    解决方式:报错原因是端口号被占用,在"src/main/resources/application.properties"中更改端口号即可

4.**已解决**第四个问题,启动SpringBoot后,css样式丢失

    Failed to load resource: the server responded with a status of 404 () bootstrap.min.css:1
    
    问题原因:springboot访问静态资源时,路径前缀中默认添加了"..static"
    
    解决方式:删掉"..static"
     <!--引入jquery文件 start-->
    <script src="/js/jquery-3.6.0.min.js"></script>
    <!--引入jquery文件 end-->
    
    <!--引入bootstrap文件 start-->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">
    <script src="/js/bootstrap.min.js"></script>
    <!--引入bootstrap文件 end-->

![bug_04](../log_bug/bug_log_img/bug_04.png)

5.**已解决**第五个问题,Oauth获取github用户信息失败,失败原因:疑似request请求发送错误,导致获取到response页面内不含有用户信息

    问题原因:github更新了Oauth获取用户的方式, 从在地址中明文传递accessToken变成了在headers中传递accessToken, header后的token中有一个**空格**容易被忽视

原先:

    Request request = new Request.Builder()
    .url("https://api.github.com/user?access_token=" + accessToken)
    .build();

现在:

    Request request = new Request.Builder()
    .url("https://api.github.com/user")
    .header("Authorization", "token " + accessToken)
    .build();

6.**已解决**第六个问题,okHttp中,RequestBody废弃了creat方法

原先:

    RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));

现在:

    RequestBody body = RequestBody.Companion.create(JSON.toJSONString(accessTokenDTO),mediaType);

7.**未解决**连接github服务器容易超时,疑似github服务器原因

8.**已解决**mysql驱动依赖引入提示警告 

问题描述:

        Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.

解决方式:

    需要将 com.mysql.jdbc.Driver  改为  com.mysql.cj.jdbc.Driver
    即:spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

9.**未解决**获取不到gmt_modify

    


