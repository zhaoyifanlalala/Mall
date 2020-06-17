package club.banyuan.javablog.controller.api;

import club.banyuan.javablog.mapper.UserMapper;
import club.banyuan.javablog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/create")
    public String create(@RequestBody User user){
        userMapper.insertSelective(user);
        return "OK";
    }
}
