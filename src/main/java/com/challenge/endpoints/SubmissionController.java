package com.challenge.endpoints;
import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/submission")

public class SubmissionController {

    @Autowired
    private SubmissionService service;

    @RequestMapping(
            params = {"challengeId","accelerationId"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> findAll (@RequestParam("challengeId") Long challengeId,
                                      @RequestParam("accelerationId") Long accelerationId) {
        return ResponseEntity.ok().body(service.findByChallengeIdAndAccelerationId(challengeId,accelerationId));
    }
}
