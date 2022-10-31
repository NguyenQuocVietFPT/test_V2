package com.vietnqph20665.test_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint",nullable = false)
    private Long id;

    @Column(name = "cate_code",length = 20,nullable = false)
    private String cate_code;

    @Column(name = "cate_name",length = 20,nullable = false)
    private String cate_name;
}
