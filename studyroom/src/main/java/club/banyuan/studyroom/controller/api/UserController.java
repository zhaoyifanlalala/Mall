package club.banyuan.studyroom.controller.api;

import club.banyuan.studyroom.common.CommonResult;
import club.banyuan.studyroom.mapper.UserMapper;
import club.banyuan.studyroom.model.User;
import club.banyuan.studyroom.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody User user, HttpSession session){

        //获取用户是否存在
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> tmpUsers = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tmpUsers)){
            return CommonResult.failed("用户不存在");
        }
        User tmpUser = tmpUsers.get(0);

        //判断密码对不对
        if (!tmpUser.getPassword().equals(user.getPassword())){
            return CommonResult.failed("密码错误！");
        }

        //放入session
        session.setAttribute("user", tmpUser);

        return CommonResult.success("OK");
    }

    @PostMapping(value = "/register")
    public CommonResult register(@RequestBody User user){
        //用户名和密码不能为空
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            return CommonResult.failed("注册失败");
        }

        userMapper.insertSelective(user);
        return CommonResult.success("OK");
    }

//    @PostMapping(value = "/current")
//    public String getname(HttpSession session, Model model){
//        User user = (User) session.getAttribute("user");
//        model.addAttribute("user", user);
//        return "OK";
//    }
}
