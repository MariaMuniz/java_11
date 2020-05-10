package com.challenge.endpoints;
import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/company")

public class CompanyController {
    @Autowired
    private CompanyService service;

    @RequestMapping(
            params = "accelerationId",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> findByAcceleration (@RequestParam Long accelerationId) {
        return ResponseEntity.ok().body(service.findByAccelerationId(accelerationId));
    }

    @RequestMapping(
            params = "userId",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> findByUser ( @RequestParam Long userId) {
        return ResponseEntity.ok().body(service.findByUserId(userId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Company> findById (@PathVariable("id") Long id){
        Optional<Company> company =service.findById(id);
        if (company.isPresent()){
            return ResponseEntity.ok().body(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
