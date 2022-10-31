package com.vietnqph20665.test_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sub_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class sub_category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    private Long id;

    @Column(name = "sub_cate_code", length = 20, nullable = false)
    private String sub_cate_code;

    @Column(name = "sub_cate_name", length = 50, nullable = false, unique = true)
    private String sub_cate_name;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private category Category;

}
