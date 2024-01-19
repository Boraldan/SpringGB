package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import com.example.sem3HomeTask.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")//localhost:8080/user
@RequiredArgsConstructor
public class UserController {

    private final RegistrationService registrationService;

    @GetMapping
    public List<User> userList(@RequestParam(value = "sortAge", required = false) boolean sortAge,
                               @RequestParam(value = "filtAge", required = false) Integer filtAge) {
        if (sortAge && filtAge != null) {
            return registrationService.getDataProcessingService().sortUsersByAge(
                    registrationService.getDataProcessingService().filterUsersByAge(filtAge));
        } else if (filtAge != null) {
            return registrationService.getDataProcessingService().filterUsersByAge(filtAge);
        } else if (sortAge) {
            return registrationService.getDataProcessingService().sortUsersByAge();
        }
        return registrationService.getDataProcessingService().findAll();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.processRegistration(user);
        return "User added from body!";
    }

    @GetMapping("/param")
    public String userAddFromParam(@RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "age", required = false) Integer age,
                                   @RequestParam(value = "email", required = false) String email) {
        if (name == null || age == null || email == null) {
            return "Укажите все параметры для User";
        }
        User user=  registrationService.getUserService().createUser(name, age, email);
        return "User added with param: " + user;
    }
}

