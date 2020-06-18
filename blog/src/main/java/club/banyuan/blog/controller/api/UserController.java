package club.banyuan.blog.controller.api;

import club.banyuan.blog.common.CommonResult;
import club.banyuan.blog.mapper.UserMapper;
import club.banyuan.blog.model.User;
import club.banyuan.blog.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody User user, HttpSession session) {

        // 获取用户在不在
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> tmpUsers = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tmpUsers)) {
            return CommonResult.failed("用户不存在！");
        }

        User tmpUser = tmpUsers.get(0);

        // 判断密码对不对
        if (!tmpUser.getPassword().equals(user.getPassword())) {
            return CommonResult.failed("密码错误！");
        }

        // 放进 Session
        session.setAttribute("user", tmpUser);
        return CommonResult.success("OK");
    }

    @PostMapping(value = "/create")
    public String create(@RequestBody User user) {
        userMapper.insertSelective(user);
        return "OK";
    }
}
