package cn.hl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class ApplicationLauncher {

    public static void main(String[] args) {
        // 时区设置：中国上海（东八区）
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(ApplicationLauncher.class, args);
    }
}
