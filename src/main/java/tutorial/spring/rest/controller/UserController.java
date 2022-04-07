package tutorial.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tutorial.spring.rest.entity.User;
import tutorial.spring.rest.exception.UserNotFoundException;
import tutorial.spring.rest.repository.UserDAO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDAO.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {

        User user = userDAO.getUser(id);

        if (null == user) throw new UserNotFoundException(id);
        return user;
    }

    /**
     * `@RequestBody` converts whatever I pass into the body of the request into User object
     * <p>
     * Note that in the web browser everything is passed as JSON objects.
     * So to automatically tell Jackson to convert the JSON object into `User` object, it is necessary to
     * put `@RequestBody`
     */
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        user = userDAO.save(user);

        // Best practice is to return a status called created along with URI to the newly created resource
        // URI would look like this: `/users/4`
        // So we need to create that first...
        // `ServletUriComponentsBuilder` class offers different methods for that
        // It can capture current request URI -> "/users"
        // Now we just need to add `4` to it -> `path` method does it
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();

        // Now we need to send this along with an OK message
        return ResponseEntity.created(location).build();
    }
}
