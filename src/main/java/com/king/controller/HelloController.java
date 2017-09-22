package com.king.controller;

import com.king.model.Plan;
import com.king.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/8/14.
 */
@Controller
//@RequestMapping("/hello")
public class HelloController {

//    @RequestMapping(method = RequestMethod.GET)
    public String getHello(Model model){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("杨", 22));
        }
        model.addAttribute("users", users);
        return "hello";
    }
}
