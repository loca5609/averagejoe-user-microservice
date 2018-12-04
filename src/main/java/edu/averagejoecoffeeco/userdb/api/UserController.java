package edu.averagejoecoffeeco.userdb.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.averagejoecoffeeco.userdb.IUserRepository;
import edu.averagejoecoffeeco.userdb.UserdbApplication;
import edu.averagejoecoffeeco.userdb.api.entities.User;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserdbApplication.class);
    @Autowired
    IUserRepository userRepo;

    @GetMapping("/allUserInfo")
    List<User> getAll() {
        List<User> result = userRepo.findAll();
        return result;
    }

    @GetMapping("/firstname/{firstname}")
    public List<User> getByFirstName(@PathVariable String firstname) {
        List<User> result = userRepo.findByfirstName(firstname);
        return result;
    }

    @GetMapping("/username/{username}")
    public User getByUserName(@PathVariable String username) {
        User result = userRepo.findByusername(username);
        return result;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        logger.info("Saving new User with info: " + user);
        User savedUser = userRepo.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/credit/{id}/{credit}")
    public ResponseEntity<User> updateCredit(@PathVariable String id, @PathVariable Double credit) {
        Optional<User> userData = userRepo.findById(id);
        if (userData.isPresent()) {
            logger.info("Adjusting user credit with id " + id + " by " + credit);
            User savedUser = userData.get();
            // don't let a users credit go below 0
            // this is buisness logic that should reside in the buisness microservice as per
            // best practices
            if ((savedUser.getCredit() - credit) < 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            savedUser.setCredit(savedUser.getCredit() - credit);
            User updatedUser = userRepo.save(savedUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
