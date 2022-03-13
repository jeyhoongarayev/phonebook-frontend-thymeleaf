package com.jeyhoon.controller;

import com.jeyhoon.client.PhonebookClient;
import com.jeyhoon.model.UserOperationResponse;
import com.jeyhoon.model.UserRequest;
import com.jeyhoon.model.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final PhonebookClient phonebookClient;

    @GetMapping("/add-user")
    public String addUser(Model model) {
        model.addAttribute("user", new UserResponse());
        return "add-user";
    }

    @PostMapping("/add-user")
    public String addUser(UserRequest userRequest) {
        UserOperationResponse userOperationResponse = phonebookClient.postUser(userRequest);
        log.info("response: {}", userOperationResponse);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", phonebookClient.getAllUsers());
        return "user";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", phonebookClient.getUser(id));
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int userId, UserRequest userRequest) {
        UserOperationResponse userOperationResponse = phonebookClient.editUser(userId, userRequest);
        log.info("response: {}", userOperationResponse);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int userId) {
        UserOperationResponse userOperationResponse = phonebookClient.deleteUser(userId);
        log.info("response: {}", userOperationResponse);
        return "redirect:/index";
    }

}
