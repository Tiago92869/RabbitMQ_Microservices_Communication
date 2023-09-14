package com.rabbit.teste.userservice.controller;

import com.rabbit.teste.userservice.dto.UserDto;
import com.rabbit.teste.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "User", description = "Manage users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    @Operation(summary = "List all users")
    @ResponseStatus(HttpStatus.OK)
    public Page<UserDto> findAllUsers(Pageable pageable){

        return this.userService.findAllUsers(pageable);
    }

    @PostMapping(value = "/")
    @Operation(summary = "Create user")
    @ResponseStatus(HttpStatus.OK)
    public UserDto createUser(@RequestBody UserDto userDto){

        return this.userService.createUser(userDto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete user")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable UUID id){

        this.userService.deleteUser(id);
    }
}
