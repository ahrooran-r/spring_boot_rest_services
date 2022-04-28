package tutorial.spring.rest.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.spring.rest.versioning.Name;
import tutorial.spring.rest.versioning.PersonV1;
import tutorial.spring.rest.versioning.PersonV2;

/**
 * Versioning via a request parameter
 */
@RestController
public class PersonVersioningController_2 {

    /**
     * URL for this would be: localhost:8080/person/param?version=1
     */
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 personV1() {
        return new PersonV1("KingKong");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 personV2() {
        return new PersonV2(new Name("King", "Kong"));
    }
}
