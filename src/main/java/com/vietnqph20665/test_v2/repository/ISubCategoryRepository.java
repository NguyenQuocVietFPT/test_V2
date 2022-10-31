package com.vietnqph20665.test_v2.repository;

import com.vietnqph20665.test_v2.model.category;
import com.vietnqph20665.test_v2.model.sub_category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubCategoryRepository extends JpaRepository<sub_category,Long> {
}
