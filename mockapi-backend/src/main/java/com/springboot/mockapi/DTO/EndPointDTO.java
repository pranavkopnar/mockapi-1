package com.springboot.mockapi.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class EndPointDTO {
    private String APIName;
    private String operation;
    private String url;
    private Map<String, Object> response;
}
