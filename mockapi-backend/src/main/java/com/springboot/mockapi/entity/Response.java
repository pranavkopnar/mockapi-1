package com.springboot.mockapi.entity;

import com.springboot.mockapi.entity.converter.HashMapConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "response"
)
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "response")
    private String responseJson;

    @Transient
    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> response;

    @OneToOne(mappedBy = "response")
    private Endpoint endpoint;
}
