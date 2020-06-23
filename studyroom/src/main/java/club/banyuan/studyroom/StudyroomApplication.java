package club.banyuan.studyroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("club.banyuan.studyroom.mapper")
public class StudyroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyroomApplication.class, args);
    }
//    @GetMapping(value = "/")
//    public String create(){
//        return "<p> Hello </p>";
//    }


}
