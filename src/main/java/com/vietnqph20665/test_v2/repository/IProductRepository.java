package com.vietnqph20665.test_v2.repository;

import com.vietnqph20665.test_v2.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<product,Long> {
}
