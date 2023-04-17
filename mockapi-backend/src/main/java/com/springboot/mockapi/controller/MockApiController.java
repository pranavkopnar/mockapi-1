package com.springboot.mockapi.controller;

import com.springboot.mockapi.service.impl.MockApiServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MockApiController {

    private final MockApiServiceImpl mockApiService;

    public MockApiController(MockApiServiceImpl mockApiService) {
        this.mockApiService = mockApiService;
    }

    @GetMapping("/**")
    public ResponseEntity<?> mockApiGet(HttpServletRequest request) {
        Map<String, Object> response = mockApiService.mockApiGet(request.getRequestURI().split(request.getContextPath() + "/api/v1")[1]);

        if (response == null) {
            return new ResponseEntity<>("Data doesn't exists", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
