package com.springboot.mockapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "endpoints"
)
public class Endpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apiName")
    private String APIName;

    @Column(name = "operation")
    private String operation;

    @Column(name = "url")
    private String url;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "response_id", referencedColumnName = "id")
    private Response response;
}
