package com.vietnqph20665.test_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    private Long id;

    @Column(name = "status_name", length = 100)
    private String status_name;

}
