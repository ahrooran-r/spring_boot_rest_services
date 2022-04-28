package tutorial.spring.rest.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.spring.rest.versioning.Name;
import tutorial.spring.rest.versioning.PersonV1;
import tutorial.spring.rest.versioning.PersonV2;

/**
 * The basic versioning method called `URI versioning`. Manually version each controller using get mapping
 * <p>
 * disadvantages: URI pollution
 * <p>
 * advantages: easy to document
 */
@RestController
public class PersonVersioningController_1 {

    @GetMapping("/v1/person")
    public PersonV1 personV1() {
        return new PersonV1("KingKong");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("King", "Kong"));
    }
}
