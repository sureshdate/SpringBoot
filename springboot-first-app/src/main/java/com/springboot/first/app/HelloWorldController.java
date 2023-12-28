package com.springboot.first.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //(this annotation is a combination of @controller and @ResponseBody.@Controller makes app as a web app
// and @ResponseBody ANNOTATION uses AS hTTpMessage converters to convert the return value of httpresponse body.)
public class HelloWorldController {
 
	@GetMapping("/hello-world")//this annotation is used for  mapping on browser.that is used for rest api
	public String HelloWorld(){
	 return "Hello World!";	
	}
}
