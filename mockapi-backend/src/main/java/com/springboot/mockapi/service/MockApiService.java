package com.springboot.mockapi.service;

import java.util.Map;

public interface MockApiService {
    Map<String, Object> mockApiGet(String url);
}
