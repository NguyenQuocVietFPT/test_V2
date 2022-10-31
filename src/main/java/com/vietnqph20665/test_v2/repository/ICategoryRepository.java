package com.vietnqph20665.test_v2.repository;

import com.vietnqph20665.test_v2.model.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<category,Long> {
}
