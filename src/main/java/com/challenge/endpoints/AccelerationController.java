package com.challenge.endpoints;
import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/acceleration")

public class AccelerationController {
    @Autowired
    AccelerationService service;

    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id) {
        Optional<Acceleration> acceleration = service.findById(id);
        if (acceleration.isPresent()) {
            return ResponseEntity.ok().body(acceleration.get());
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