
package com.codetutr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {
	

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "formmain";
	}
}
