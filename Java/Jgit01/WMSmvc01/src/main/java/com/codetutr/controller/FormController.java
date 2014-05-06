
package com.codetutr.controller;

import com.codetutr.model.Animal;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@ModelAttribute("animal") Animal animal) {
        return returnFormMain();
    }

    private String returnFormMain() {
        return "formmain";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String helloPost(@ModelAttribute("animal") @Valid Animal animal, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            
            return returnFormMain();
        }

        return "formmainresult";
    }
}
