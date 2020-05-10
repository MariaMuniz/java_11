package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")


public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(
            params = "accelerationName",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> findByAccelerationName(@RequestParam String accelerationName) {
        return ResponseEntity.ok().body(service.findByAccelerationName(accelerationName));
    }

    @RequestMapping(
            params = "companyId",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> findByCompany(@RequestParam Long companyId) {
        return ResponseEntity.ok().body(service.findByCompanyId(companyId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        Optional<User> user = service.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}