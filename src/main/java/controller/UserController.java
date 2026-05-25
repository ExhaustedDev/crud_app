package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.readUsers());

        return "users";
    }

    @GetMapping("/add_user")
    public String addUsers(Model model) {
        model.addAttribute("addedUser", new User());

        return "add_user";
    }

    @PostMapping("/add_user")
    public String addUsers(@ModelAttribute("addedUser") User user) {
        userService.createUser(user);

        return "redirect:/add_user";
    }

    @PostMapping("/delete")
    public String removeUser(@RequestParam Long id) {
        User userById = userService.findUserById(id);

        userService.removeUser(userById);

        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam Long id, Model model) {
        User foundUser = userService.findUserById(id);

        model.addAttribute("updatedUser", foundUser);

        return "edit_user";
    }

    @PostMapping("/edit")
    public String editUserPost(@ModelAttribute("updatedUser") User user) {
        userService.updateUser(user);

        return "redirect:/";
    }

}
