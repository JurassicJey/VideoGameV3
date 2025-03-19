package com.example.videogamev3.UserManagement.Presentation;

import com.example.videogamev3.UserManagement.BusinessLogic.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<UserResponseModel> getUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("{uuid}")
    public UserResponseModel getUserById(@PathVariable String uuid) {
        return userService.getUserById(uuid);
    }

    @PostMapping()
    public UserResponseModel addUser(@RequestBody UserRequestModel userRequestModel) {
        return userService.addUser(userRequestModel);
    }

    @PutMapping("{uuid}")
    public UserResponseModel updateUser(@RequestBody UserRequestModel userRequestModel, @PathVariable String uuid) {
        return userService.updateUser(userRequestModel, uuid);
    }

    @DeleteMapping("{uuid}")
    public void deleteUser(@PathVariable String uuid) {
        userService.deleteUser(uuid);
    }
}
