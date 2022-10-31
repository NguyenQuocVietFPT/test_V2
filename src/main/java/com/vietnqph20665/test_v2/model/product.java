package com.vietnqph20665.test_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    private Long id;

    @Column(name = "product_name", length = 100)
    private String product_name;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "quantity", columnDefinition = "bigint")
    private Long quantity;

    @Column(name = "origin_price")
    private Double origin_price;

    @Column(name = "sell_price")
    private Double sell_price;

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "subcate_id")
    private sub_category subCategory;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private status staTus;

    @ManyToMany
    @JoinTable(name = "product_brand",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private Set<brand> brands;

    public void addBrand(brand bra){
        this.brands.add(bra);
    }

}
