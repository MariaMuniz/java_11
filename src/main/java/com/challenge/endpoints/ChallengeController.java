package com.challenge.endpoints;


import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    @Autowired
    private ChallengeService service;


    @GetMapping
    @RequestMapping(
            params = {"accelerationId", "userId"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> findByAccelerationAndUser(@RequestParam("accelerationId") Long accelerationId,
                                                       @RequestParam("userId") Long userId) {
        return ResponseEntity.ok().body(service.findByAccelerationIdAndUserId(accelerationId, userId));

    }

}
