package com.springboot.mockapi.service.impl;

import com.springboot.mockapi.DTO.EndPointDTO;
import com.springboot.mockapi.entity.Endpoint;
import com.springboot.mockapi.entity.Response;
import com.springboot.mockapi.entity.converter.HashMapConverter;
import com.springboot.mockapi.repository.EndpointRepository;
import com.springboot.mockapi.service.EndpointService;
import org.springframework.stereotype.Service;

@Service
public class EndpointServiceImpl implements EndpointService {

    private final EndpointRepository endpointRepository;

    private final HashMapConverter hashMapConverter;

    public EndpointServiceImpl(EndpointRepository endpointRepository, HashMapConverter hashMapConverter) {
        this.endpointRepository = endpointRepository;
        this.hashMapConverter = hashMapConverter;
    }

    @Override
    public String saveEndpoint(EndPointDTO endPointDTO) {
        Endpoint endpoint = new Endpoint();
        endpoint.setAPIName(endPointDTO.getAPIName());
        endpoint.setOperation(endPointDTO.getOperation());
        endpoint.setUrl(endPointDTO.getUrl());

        Response response = new Response();
        response.setResponse(endPointDTO.getResponse());
        response.setResponseJson(hashMapConverter.convertToDatabaseColumn(endPointDTO.getResponse()));

        endpoint.setResponse(response);

        endpointRepository.save(endpoint);
        return "Successfully saved endpoint";
    }
}
