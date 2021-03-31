package lk.sadeep.mms.lolc.controller;

import lk.sadeep.mms.lolc.dto.MainPageDTO;
import lk.sadeep.mms.lolc.dto.UserDTO;
import lk.sadeep.mms.lolc.entiry.MainPage;
import lk.sadeep.mms.lolc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createAnUser(@RequestBody UserDTO userDTO)
    {
        return new ResponseEntity<>(userService.createAnUser(userDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserDTO userDTO)
    {
        return userService.login(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getAnUser(@PathVariable("id") Integer id)
    {
        return userService.getAUser(id);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO userDTO)
    {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteAUser(id);
    }

    @GetMapping("/pages/{id}")
    public List<MainPage> getUserPages(@PathVariable("id") Integer id)
    {
        return userService.getPages(id);
    }
}
