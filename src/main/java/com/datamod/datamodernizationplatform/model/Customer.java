package com.datamod.datamodernizationplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customers")
public class Customer {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String email;

}

