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