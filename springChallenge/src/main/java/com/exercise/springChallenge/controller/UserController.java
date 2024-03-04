package com.exercise.springChallenge.controller;

import com.exercise.springChallenge.entity.User;
import com.exercise.springChallenge.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/registration")
    public String displayForm() {
        return"userform";
    }

    @PostMapping("/userList")
    public String processData(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                  @RequestParam("email") String email, Model model) {
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        userRepo.save(user);

        List<User> userList = userRepo.findAll();

        model.addAttribute("usersList", userList);



        return "displayusers";
    }


}
