package tutorial.spring.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.spring.rest.repository.SomeBean;

@RestController
public class FilteringController {

    @GetMapping("/static-filter")
    private SomeBean retrieveSomeBean() {
        return new SomeBean(
                "203977V",
                "KingKong",
                "somePassword",
                "running",
                "cake",
                20
        );
    }
}
