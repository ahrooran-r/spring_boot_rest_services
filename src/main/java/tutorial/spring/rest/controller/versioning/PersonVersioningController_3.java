package tutorial.spring.rest.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.spring.rest.versioning.Name;
import tutorial.spring.rest.versioning.PersonV1;
import tutorial.spring.rest.versioning.PersonV2;

/**
 * Versioning via Header Params
 * <p>
 * disadvantages: misuse of HTTP headers, has problems in caching because I also have to look at headers
 */

@RestController
public class PersonVersioningController_3 {

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 personV1() {
        return new PersonV1("KingKong");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 personV2() {
        return new PersonV2(new Name("King", "Kong"));
    }
}
