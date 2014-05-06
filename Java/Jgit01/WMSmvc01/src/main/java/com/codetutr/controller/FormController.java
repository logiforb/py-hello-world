
package com.codetutr.controller;

import com.codetutr.model.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(@ModelAttribute("animal") Animal animal) {
            return "formmain";
	}
        
        @RequestMapping(value="/hello", method=RequestMethod.POST)
	public String helloPost(@ModelAttribute("animal") Animal animal) {
            
//            Animal animal = new Animal(33);
//            model.addAttribute("animal", animal);
            
            return "formmainresult";
	}
}
