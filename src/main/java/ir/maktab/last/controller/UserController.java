package ir.maktab.last.controller;

import ir.maktab.last.entity.User;
import ir.maktab.last.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String firstPage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.create(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors())
            return "update-user";
        user.setId(userService.findById(id).getId());
        userService.create(user);
        user = userService.create(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.findById(id);
        userService.delete(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);

        return "update-user";
    }
}
