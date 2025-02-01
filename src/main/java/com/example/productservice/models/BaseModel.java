package com.example.productservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id // for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
    private long id;
    private Date CreatedAt;
    private Date UpdatedAt;
}
