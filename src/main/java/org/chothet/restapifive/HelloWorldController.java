package org.chothet.restapifive;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController (MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(path="hello-world")      //@RequestMapping(method= RequestMethod.GET, path="/hello-world")
    public String helloWorld(){

        return "Hello World!";
    }

    @GetMapping(path="hello-world-bean")
    public HelloWorldBean helloWorldBean(){

        return new HelloWorldBean("Hello World Bean!");         //public HelloWorldBean
    }

    @GetMapping(path="/hello-world/path-variable/{name}")                   //http://localhost:8080/hello-world/path-variable/YaMone
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name ){

        return new HelloWorldBean( String.format("Hello World, %s", name) );
    }

    @GetMapping(path="hello-world-initialized")      //name: Accept-Language, value:nl
    public String helloWorldInitialized(){
        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }

}


//path parameters -> /users/{id}/todos/{id}