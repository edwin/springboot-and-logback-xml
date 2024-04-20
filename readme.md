# Spring Boot and Logback

a simple logback.xml config for Spring Boot apps, configurable thru environment variables for dynamic configuration.

## Configuration
Parameterizing using `ROOT_LOG_LEVEL` for the root logger, and `APP_LOG_LEVEL`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <property name="ROOT_LOG_LEVEL" value="${ROOT_LOG_LEVEL:-WARN}" />
    <property name="APP_LOG_LEVEL" value="${APP_LOG_LEVEL:-INFO}" />

    <appender name="CONSOLE"
              class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
            <charset>utf8</charset>
        </encoder>
    </appender>

    <logger name="com.edw" level="${APP_LOG_LEVEL}" additivity="false">
        <appender-ref ref="CONSOLE" />
    </logger>

    <root level="${ROOT_LOG_LEVEL}">
        <appender-ref ref="CONSOLE" />
    </root>
</configuration>
```

## Sample Usage with JVM Option
Without any configuration
```
$  java -jar springboot-and-logback-xml-1.0-SNAPSHOT.jar

  .   ____          _            __ _ _    
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \   
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \  
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) ) 
  '  |____| .__|_| |_|_| |_\__, | / / / /  
 =========|_|==============|___/=/_/_/_/   
 :: Spring Boot ::                (v3.0.4) 

14:12:49.321 [main] INFO  com.edw.Main - Starting Main v1.0-SNAPSHOT using Java 17.0.6 with PID 13480 (D:\source\springboot-and-logback-xml\target\springboot-and-logback-xml-1.0-SNAPSHOT.jar started by thinkpad 
in D:\source\springboot-and-logback-xml)
14:12:49.326 [main] INFO  com.edw.Main - No active profile set, falling back to 1 default profile: "default" 
14:12:51.122 [main] INFO  com.edw.Main - Started Main in 2.283 seconds (process running for 2.983) 
14:13:02.489 [http-nio-8080-exec-1] INFO  com.edw.controller.IndexController - we are at index page using INFO 
```

With `APP_LOG_LEVEL` configuration
```
$ java -DAPP_LOG_LEVEL=DEBUG -jar springboot-and-logback-xml-1.0-SNAPSHOT.jar

  .   ____          _            __ _ _    
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \   
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \  
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) ) 
  '  |____| .__|_| |_|_| |_\__, | / / / /  
 =========|_|==============|___/=/_/_/_/   
 :: Spring Boot ::                (v3.0.4) 

14:14:10.135 [main] INFO  com.edw.Main - Starting Main v1.0-SNAPSHOT using Java 17.0.6 with PID 7536 (D:\source\springboot-and-logback-xml\target\springboot-and-logback-xml-1.0-SNAPSHOT.jar started by thinkpad i
n D:\source\springboot-and-logback-xml)
14:14:10.138 [main] DEBUG com.edw.Main - Running with Spring Boot v3.0.4, Spring v6.0.6                      
14:14:10.139 [main] INFO  com.edw.Main - No active profile set, falling back to 1 default profile: "default" 
14:14:12.038 [main] INFO  com.edw.Main - Started Main in 2.377 seconds (process running for 3.094) 
14:14:12.892 [http-nio-8080-exec-1] DEBUG com.edw.controller.IndexController - we are at index page using DEBUG 
14:14:12.895 [http-nio-8080-exec-1] INFO  com.edw.controller.IndexController - we are at index page using INFO 
```

With `ROOT_LOG_LEVEL` and `APP_LOG_LEVEL` configuration
```
$ java -DAPP_LOG_LEVEL=DEBUG -DROOT_LOG_LEVEL=INFO -jar springboot-and-logback-xml-1.0-SNAPSHOT.jar

  .   ____          _            __ _ _    
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \   
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \  
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) ) 
  '  |____| .__|_| |_|_| |_\__, | / / / /  
 =========|_|==============|___/=/_/_/_/   
 :: Spring Boot ::                (v3.0.4) 
 
14:15:40.353 [main] INFO  com.edw.Main - Starting Main v1.0-SNAPSHOT using Java 17.0.6 with PID 9004 (D:\source\springboot-and-logback-xml\target\springboot-and-logback-xml-1.0-SNAPSHOT.jar started by thinkpad i
n D:\source\springboot-and-logback-xml)
14:15:40.356 [main] DEBUG com.edw.Main - Running with Spring Boot v3.0.4, Spring v6.0.6                      
14:15:40.357 [main] INFO  com.edw.Main - No active profile set, falling back to 1 default profile: "default" 
14:15:41.774 [main] INFO  o.s.b.w.e.tomcat.TomcatWebServer - Tomcat initialized with port(s): 8080 (http) 
14:15:41.788 [main] INFO  o.a.coyote.http11.Http11NioProtocol - Initializing ProtocolHandler ["http-nio-8080"] 
14:15:41.789 [main] INFO  o.a.catalina.core.StandardService - Starting service [Tomcat]
14:15:41.789 [main] INFO  o.a.catalina.core.StandardEngine - Starting Servlet engine: [Apache Tomcat/10.1.5]
14:15:41.903 [main] INFO  o.a.c.c.C.[Tomcat].[localhost].[/] - Initializing Spring embedded WebApplicationContext 
14:15:41.905 [main] INFO  o.s.b.w.s.c.ServletWebServerApplicationContext - Root WebApplicationContext: initialization completed in 1449 ms 
14:15:42.365 [main] INFO  o.a.coyote.http11.Http11NioProtocol - Starting ProtocolHandler ["http-nio-8080"] 
14:15:42.404 [main] INFO  o.s.b.w.e.tomcat.TomcatWebServer - Tomcat started on port(s): 8080 (http) with context path '' 
14:15:42.425 [main] INFO  com.edw.Main - Started Main in 2.604 seconds (process running for 3.422) 
14:17:29.454 [http-nio-8080-exec-1] INFO  o.a.c.c.C.[Tomcat].[localhost].[/] - Initializing Spring DispatcherServlet 'dispatcherServlet' 
14:17:29.455 [http-nio-8080-exec-1] INFO  o.s.web.servlet.DispatcherServlet - Initializing Servlet 'dispatcherServlet' 
14:17:29.456 [http-nio-8080-exec-1] INFO  o.s.web.servlet.DispatcherServlet - Completed initialization in 1 ms
14:17:29.490 [http-nio-8080-exec-1] DEBUG com.edw.controller.IndexController - we are at index page using DEBUG 
14:17:29.492 [http-nio-8080-exec-1] INFO  com.edw.controller.IndexController - we are at index page using INFO 
```

## Usage with Environment Variables
We can inject both `ROOT_LOG_LEVEL` and `APP_LOG_LEVEL` thru environment variables (especially in a containerized environment).