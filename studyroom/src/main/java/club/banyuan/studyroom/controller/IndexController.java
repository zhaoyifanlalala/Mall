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
//        User user = (User) session.getAttribute("user");
//        model.addAttribute("user", user);
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




    @GetMapping("/studyroom/login")
    public String studyRoomLogin() {
        return "/login";
    }

    @GetMapping("/studyroom/register")
    public String studyRoomRegister() {
        return "/register";
    }


    @GetMapping("/studyroom/index")
    public String studyRoomIndex() {
        return "/index";
    }

    @GetMapping("/studyroom/book")
    public String studyRoomBook() {
        return "/book";
    }

    @GetMapping("/studyroom/history")
    public String studyRoomHistory() {
        return "/history";
    }

    @GetMapping("/studyroom/admin")
    public String studyRoomAdmin() {
        return "/admin";
    }

    @GetMapping("/studyroom/admin/records")
    public String studyRoomAdminRecords() {
        return "/adminRecords";
    }

    @GetMapping("/studyroom/admin/positions")
    public String studyRoomAdminPositions() {
        return "/adminPositions";
    }

    @GetMapping("/studyroom/admin/login")
    public String studyRoomAdminLogin() {
        return "/adminLogin";
    }
}
