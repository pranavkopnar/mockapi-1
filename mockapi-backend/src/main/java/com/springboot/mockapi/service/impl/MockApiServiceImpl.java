package com.springboot.mockapi.service.impl;

import com.springboot.mockapi.entity.Endpoint;
import com.springboot.mockapi.entity.Response;
import com.springboot.mockapi.entity.converter.HashMapConverter;
import com.springboot.mockapi.repository.EndpointRepository;
import com.springboot.mockapi.service.MockApiService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MockApiServiceImpl implements MockApiService {

    private final EndpointRepository endpointRepository;

    private final HashMapConverter hashMapConverter;

    public MockApiServiceImpl(EndpointRepository endpointRepository, HashMapConverter hashMapConverter) {
        this.endpointRepository = endpointRepository;
        this.hashMapConverter = hashMapConverter;
    }

    @Override
    public Map<String, Object> mockApiGet(String url) {

        System.out.println(url);
        Endpoint endpoint = endpointRepository.findEndpointByUrl(url);
        Response response = endpoint.getResponse();

        return hashMapConverter.convertToEntityAttribute(response.getResponseJson());
    }
}
