package hr.igord.controllers;

import hr.igord.models.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homeGet(@ModelAttribute("animal") Animal animal) {
//        return "homeform";
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String homePost(@ModelAttribute("animal") Animal animal) {
        return "homeresult";
    }
}
