package com.springboot.mockapi.controller;

import com.springboot.mockapi.DTO.EndPointDTO;
import com.springboot.mockapi.service.impl.EndpointServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/1.0")
public class ApiController {

    private final EndpointServiceImpl endpointService;

    public ApiController(EndpointServiceImpl endpointService) {
        this.endpointService = endpointService;
    }

    @PostMapping("/saveEndpoint")
    public ResponseEntity<?> saveEndpoint(@RequestBody EndPointDTO endpoint) {
        System.out.println(endpoint.getAPIName());
        return new ResponseEntity<>(endpointService.saveEndpoint(endpoint), HttpStatus.OK);
    }
}
