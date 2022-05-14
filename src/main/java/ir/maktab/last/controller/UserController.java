package ir.maktab.last.controller;

import ir.maktab.last.entity.User;
import ir.maktab.last.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "ali");
        return "index";

    }
   @GetMapping("/findAll")
    public String findAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }
}
