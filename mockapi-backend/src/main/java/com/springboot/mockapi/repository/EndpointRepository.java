package com.springboot.mockapi.repository;

import com.springboot.mockapi.entity.Endpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointRepository extends JpaRepository<Endpoint, Long> {
    Endpoint findEndpointByUrl(String url);
}
