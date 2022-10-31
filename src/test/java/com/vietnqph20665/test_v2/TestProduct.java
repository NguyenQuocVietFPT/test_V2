package com.vietnqph20665.test_v2;

import com.vietnqph20665.test_v2.model.*;
import com.vietnqph20665.test_v2.repository.IBrandRepository;
import com.vietnqph20665.test_v2.repository.IProductRepository;
import com.vietnqph20665.test_v2.repository.IStatusRepository;
import com.vietnqph20665.test_v2.repository.ISubCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TestProduct {

    @Autowired
    private IProductRepository _proRepo;

    @Autowired
    private IBrandRepository _braRepo;

    @Autowired
    private ISubCategoryRepository _subRepo;

    @Autowired
    private IStatusRepository _staRepo;

    @Test
    private void addProduct() {
        sub_category sub = _subRepo.findById(Long.valueOf(16)).get();
        status sta = _staRepo.findById(Long.valueOf(1)).get();
        brand bra = _braRepo.findById(Long.valueOf(1)).get();

        product pro = new product();
        pro.setColor("red");
        pro.setDescription("beautiful");
        pro.setSell_price(100.6);
        pro.setOrigin_price(100.0);
        pro.setQuantity(Long.valueOf(10));
        pro.setProduct_name("iphone");
        pro.setStaTus(sta);
        pro.setSubCategory(sub);
        pro.addBrand(bra);

        _proRepo.save(pro);

    }
}
