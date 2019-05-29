# aisen
爱神 - AI交友平台

## Run on IntelliJ IDEA
1. Create database from `database/users.sql`
1. Import project as maven project
1. Edit `application-dev.properties`
1. Click `AisenApplication` run the app
1. Click `stop` and edit run config, add VM options `-Dspring.profiles.active=dev` to Springboot -> AisenApplication
1. Restart `AisenApplication`

### Edit `application-dev.properties`
e.g.
```
// change mysql host:port/dbname
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/dbname?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&useSSL=true&allowMultiQueries=true&serverTimezone=Asia/Hong_Kong
spring.datasource.username=your mysql username
spring.datasource.password=your mysql password
```
##  Create api doc.html With swagger 
//change ip and port if necessery
http://127.0.0.1:8086/doc.html  
//how to config swagger 
com.birthday.aisen.common.SwaggerConfig
