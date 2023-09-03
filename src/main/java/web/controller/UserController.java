package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;


import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all_users";
    }
    @GetMapping("/addNewUser")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user_info";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/get")
    public String getUser(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getUser(id));
        return "get";
    }

    @PatchMapping("{id}")
    public String updateUser (@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/";
    }

}

