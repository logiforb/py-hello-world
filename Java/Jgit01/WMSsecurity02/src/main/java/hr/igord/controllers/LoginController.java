package hr.igord.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public ModelAndView loginGet(@RequestParam(value = "error", required = false) String error) {

        ModelAndView model = new ModelAndView("login");
        
        if (error != null) {
            model.addObject("error", "(TEST) Wrong username or password!");
        }
        
        return model;
    }
}
