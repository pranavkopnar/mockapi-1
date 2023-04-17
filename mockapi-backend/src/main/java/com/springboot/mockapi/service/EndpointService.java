package com.springboot.mockapi.service;

import com.springboot.mockapi.DTO.EndPointDTO;

public interface EndpointService {
    String saveEndpoint(EndPointDTO endpoint);
}
