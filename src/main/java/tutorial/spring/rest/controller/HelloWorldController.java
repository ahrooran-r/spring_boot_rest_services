package tutorial.spring.rest.controller;

import org.springframework.web.bind.annotation.*;
import tutorial.spring.rest.repository.HelloWorldBean;

@RestController
@RequestMapping(method = RequestMethod.GET, path = "/hello")
// If we don't specify a `method`, it's going to map to any HTTP request.
public class HelloWorldController {

    // Whenever we use a REST service, we define 2 things:
    // 1. GET, POST, etc
    // 2. URL

    // Instead of using @RequestMapping like above
    // we can directly use @GetMapping
    // It is more readable and easy
    @GetMapping("/world")
    public String helloWorld() {
        return "Hello World";
    }

    /**
     * @return A bean instead of raw String
     */
    @GetMapping("/world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Bean");
    }

    /**
     * @param name is a path variable denoted by {name}
     */
    @GetMapping("/world/{name}")
    public String helloWorldBeanWithPathParam(@PathVariable String name) {
        return "HelloWorld -> Your name is: " + name;
    }
}
