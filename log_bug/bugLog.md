1.**已解决**第一个bug,创建SpringBoot,maven插件错误
    
    未找到插件 'org.springframework.boot:spring-boot-maven-plugin
    
    解决方式:加入版本号<version>2.4.5</version>/**2.4.5为ide推荐版本号,也是我选择的springboot版本**/
         <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.4.5</version>
         </plugin>
