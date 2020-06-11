package club.banyuan;

import club.banyuan.mall.common.mapper.UmsRoleMapper;
import club.banyuan.mall.common.model.UmsRole;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
@MapperScan({"club.banyuan.mall.common.mapper"})
public class MallApplication {
    @Autowired
    private UmsRoleMapper roleMapper;
//    @Autowired
//    public MallApplication(UmsRoleMapper roleMapper) {
//        this.roleMapper = roleMapper;
//    }

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class,args);
    }
    @GetMapping(value = "/")
    public String index(){

//        UmsRole role = new UmsRole();
//        role.setName("管理员");
//        role.setDescription("管理员不用介绍");
//        role.setStatus(true);
//        role.setCreateTime(new Date());
//        roleMapper.insert(role);
//
//        return "<h1>Hello World33!<h1>";


        UmsRole role = roleMapper.selectByPrimaryKey(1L);

        return "<p>" + role.toString() + "</p>";

    }
    @GetMapping(value = "/hello")
    public String hello(){
        return "HELLO";
    }
    @GetMapping(value = "/hello2")
    public String hello2(){
        return "HELLO";
    }
}

