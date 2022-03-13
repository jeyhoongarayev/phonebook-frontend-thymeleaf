package com.jeyhoon.client;

import com.jeyhoon.model.UserOperationResponse;
import com.jeyhoon.model.UserRequest;
import com.jeyhoon.model.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "phonebook-api", url = "${backend.phonebook-backend-api}")
public interface PhonebookClient {

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") int userId);

    @GetMapping
    List<UserResponse> getAllUsers();

    @PostMapping
    UserOperationResponse postUser(@RequestBody UserRequest userRequest);

    @PutMapping(value = "/{userId}")
    UserOperationResponse editUser(@PathVariable("userId") int userId, @RequestBody UserRequest userRequest);

    @DeleteMapping(value = "/{userId}")
    UserOperationResponse deleteUser(@PathVariable("userId") int userId);

}
