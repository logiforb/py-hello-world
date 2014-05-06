package controllers;

import javax.validation.Valid;
import javax.validation.Validator;
import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Service
@Controller
public class PersController {

    //org.springframework.validation.Validator
    //http://docs.spring.io/spring/docs/4.0.4.RELEASE/spring-framework-reference/htmlsingle/#validation-beanvalidation
    
//    @Autowired
//    private Validator validator;
    
    @RequestMapping(value="/pers", method=RequestMethod.GET)
    public String greetingForm(@ModelAttribute("pers") Person pers) {
//        model.addAttribute("pers", new Person());
        return returnToInput();
    }

    private String returnToInput() {
        return "persinput";
    }

    @RequestMapping(value="/pers", method=RequestMethod.POST)
    public String greetingSubmit(
            @ModelAttribute("pers")
            @Valid
            Person pers,
            BindingResult bindingResult) {
        
//        model.addAttribute("pers", person);
        if (bindingResult.hasErrors()) {
            System.out.println("----------------");
            System.out.println("Binding Result HAS ERRORS");
            System.out.println("----------------");
            return returnToInput();
        }
        
        System.out.println("----------------");
        System.out.println("Binding Result has no errors");
        System.out.println("----------------");
        
        return "persresult";
    }

}