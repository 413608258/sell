package com.lous.sell.repository;

import com.lous.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void finOneTest(){
        Optional<ProductCategory> productCategory = repository.findById(1);
        productCategory.get().setCategoryName("xiugai");
        repository.save(productCategory.get());
        System.out.println("productCategory = " + productCategory);
    }
    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱",4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCategoryTypeIn(){
        List<ProductCategory> categories = repository.findByCategoryTypeIn(Arrays.asList(2, 3, 4));
        System.out.println("categories = " + categories);
        Assert.assertNotEquals(0, categories.size());
    }

}