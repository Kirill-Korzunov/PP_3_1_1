package spring.boot.pp_3_1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.boot.pp_3_1_1.model.User;
import spring.boot.pp_3_1_1.service.UserService;


import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUserShow(Model model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @PostMapping(value = "/addNewUserPost")
    public String addNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "user-info";
        } else {
            userService.add(user);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/updateUser")
    public String updateUserShow(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user-info-edit";
    }

    @PostMapping(value = "/updateUserPost")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "user-info-edit";
        } else {
            userService.update(user);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUserShow(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user-delete";
    }

    @PostMapping(value = "/deleteUserPost")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
