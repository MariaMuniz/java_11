package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/candidate")

public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<Candidate> findById(@PathVariable("userId") Long userId,
                                              @PathVariable("accelerationId") Long accelerationId,
                                              @PathVariable("companyId") Long companyId) {
        Optional<Candidate> candidate = service.findById(userId, companyId, accelerationId);
        if (candidate.isPresent()) {
            return ResponseEntity.ok().body(candidate.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(
            params = "companyId",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> findByCompany(@RequestParam Long companyId) {
        return ResponseEntity.ok().body(service.findByCompanyId(companyId));
    }
}
