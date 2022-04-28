package tutorial.spring.rest.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.spring.rest.versioning.Name;
import tutorial.spring.rest.versioning.PersonV1;
import tutorial.spring.rest.versioning.PersonV2;

/**
 * Versioning via `Produces`. This is also a header parameter. But little different.
 * <p>
 * Also called `Accept Header Versioning`
 * <p>
 * disadvantages: misuse of HTTP headers, has problems in caching because I also have to look at headers
 */

@RestController
public class PersonVersioningController_4 {

    /**
     * Produces defines what are we producing out of our application -> typically it is JSON strings
     * <p>
     * Hence `produces = "application/json"` by default
     * <p>
     * But now we are adding versioning to it
     * <p>
     * To utilize this: we use the `Accept` header in browser
     */
    @GetMapping(value = "/person/produces", produces = "application/tutorial.spring.rest-v1+json")
    public PersonV1 personV1() {
        return new PersonV1("KingKong");
    }

    @GetMapping(value = "/person/produces", produces = "application/tutorial.spring.rest-v1+json")
    public PersonV2 personV2() {
        return new PersonV2(new Name("King", "Kong"));
    }
}
