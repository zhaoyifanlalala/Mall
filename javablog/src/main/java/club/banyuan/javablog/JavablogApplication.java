package club.banyuan.javablog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("club.banyuan.javablog.mapper")

public class JavablogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavablogApplication.class, args);
    }

}
