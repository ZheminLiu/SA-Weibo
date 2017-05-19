# SA-Weibo
软件体系结构课程项目

## Step1：设计与实现观察者体系结构（解耦）  

针对微博应用，实现对微博的后台操作，具体要求如下：  

1、实现微博对象（即被观察者Observable），用于存储并操作微博内容，包括查看、修改、增加、删除等功能，  
   微博内容一旦改变，会通知"日志构件"记录操作日志。  
   微博被阅读一次，通知"记数构件"记录阅读次数（因此，是两种事件，日志构件和计数构件关注的是不同事件）。  
   
2、实现一个日志构件（即Observer）,用于微博记录操作日志.  

3、实现一个记数构件（即Observer）,用于记录微博点击次数.  

4、数据库自行设计，通过JDBC操作数据库