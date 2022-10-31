package com.vietnqph20665.test_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    private Long id;

    @Column(name = "brand_name", length = 100)
    private String brand_name;

    @Override
    public String toString() {
        return brand_name;
    }
}
