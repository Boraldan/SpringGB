package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Log4j2
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String findAll(Model model) {
        log.info("Получили всех юзеров");
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        log.info("Форма для создания нового User");
        model.addAttribute("user", new User());
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        log.info("Получили POST для создания нового User");
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        log.info("Удалили User по id");
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        log.info("Форма для обновления User");
        model.addAttribute("user", userService.findById(id));
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUserPost(@ModelAttribute("user") User user) {
        log.info("Получили POST для обновления User");
        userService.updateUser(user);
        return "redirect:/users";
    }
}
