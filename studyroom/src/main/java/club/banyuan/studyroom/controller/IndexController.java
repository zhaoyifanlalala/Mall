package club.banyuan.studyroom.controller;

import club.banyuan.studyroom.mapper.UserMapper;
import club.banyuan.studyroom.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/")
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping(value = "/logout")
    public String demo(Model model, HttpSession session) {
        session.removeAttribute("user");
        return "forward:/";
    }
}
