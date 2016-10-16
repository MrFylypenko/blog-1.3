package net.bleser.controller;

import net.bleser.entity.Message;
import net.bleser.entity.User;
import net.bleser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by bleser on 16.10.16.
 */
@Controller
public class USerController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/", "posts"}, method = RequestMethod.GET)
    public String main(Model model){
        User username = userService.findUsername("Bleser");
        System.out.println(username);
//        model.addAttribute("messages", bleser);

        return "posts";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("test", "login");

        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("test", "registration");

        return "registration";
    }
}
