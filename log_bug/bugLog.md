---
typora-root-url: bug_log_img
---

1.**�ѽ��**��һ��bug,����SpringBoot,maven�������
    
    δ�ҵ���� 'org.springframework.boot:spring-boot-maven-plugin
    
    �����ʽ:����汾��<version>2.4.5</version>/**2.4.5Ϊide�Ƽ��汾��,Ҳ����ѡ���springboot�汾**/
         <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.4.5</version>
         </plugin>

2.**�ѽ��**�ڶ�������,����bootstrapʱ�������޷�Ӧ
    
    ȱʧjquery�ļ�,bootstrapһϵ�в�����Ҫ����jquery�����ſ�ʵ��
    
    �����ʽ:������bootstrapǰ������jquery�ļ�
        <!--����jquery�ļ� start-->
        <script src="../static/js/jquery-3.6.0.min.js"></script>
        <!--����jquery�ļ� end-->
    
        <!--����bootstrap�ļ� start-->
        <link rel="stylesheet" href="../static/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="../static/css/bootstrap.min.css">
        <script src="../static/js/bootstrap.min.js"></script>
        <!--����bootstrap�ļ� end-->

3.**�ѽ��**����������,����springboot����

    Whitelabel Error Page
    This application has no explicit mapping for /error, so you are seeing this as a fallback.
    
    Wed Apr 21 22:20:50 CST 2021
    There was an unexpected error (type=Not Found, status=404).
    
    �����ʽ:����ԭ���Ƕ˿ںű�ռ��,��"src/main/resources/application.properties"�и��Ķ˿ںż���

4.**δ���**���ĸ�����,����SpringBoot��,css��ʽ��ʧ
    
    Failed to load resource: the server responded with a status of 404 () bootstrap.min.css:1
    
    ����ԭ��:springboot���ʾ�̬��Դʱ,·��ǰ׺��Ĭ�������"..static"
    
    �����ʽ:ɾ��"..static"
     <!--����jquery�ļ� start-->
    <script src="/js/jquery-3.6.0.min.js"></script>
    <!--����jquery�ļ� end-->
    
    <!--����bootstrap�ļ� start-->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">
    <script src="/js/bootstrap.min.js"></script>
    <!--����bootstrap�ļ� end-->
    
![](../bug_log_img/bug_04.png)