package com.lous.sell.dataobject.mapper;

import com.lous.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("categoryName", "新新新");
        map.put("categoryType", 99);

        int i = mapper.insertByMap(map);
        Assert.assertEquals(1, i);
    }
    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("最新");
        productCategory.setCategoryType(999);

        int i = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, i);
    }
    @Test
    public void findByCategoryType() {
        ProductCategory productCategory = mapper.findByCategoryType(999);
        Assert.assertNotNull(productCategory);
    }
    @Test
    public void updateByCategoryType() {
        int i = mapper.updateByCategoryType("师兄不爱分类", 999);
        Assert.assertEquals(1, i);
    }
    @Test
    public void updateByCategoryObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("最新");
        productCategory.setCategoryType(999);
        int i = mapper.updateByCategoryObject(productCategory);
        Assert.assertEquals(1, i);
    }
}