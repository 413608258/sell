package com.lous.sell.controller;

import com.alibaba.fastjson.JSON;
import com.lous.sell.dataobject.ProductCategory;
import com.lous.sell.dataobject.ProductInfo;
import com.lous.sell.dto.OrderDTO;
import com.lous.sell.form.ProductForm;
import com.lous.sell.repository.ProductInfoRepository;
import com.lous.sell.service.ICategoryService;
import com.lous.sell.service.IProductService;
import com.lous.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : SellerProductController
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-06
 **/
 @Controller
 @RequestMapping("/seller/product")
 @Slf4j
public class SellerProductController {

     @Autowired
     IProductService productService;
     @Autowired
     ProductInfoRepository repository;
     @Autowired
    ICategoryService categoryService;

     @GetMapping("/list")
     public ModelAndView list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                              Map<String, Object> map){
         PageRequest request = new PageRequest(page - 1, size);
         Page<ProductInfo> productInfoPage = productService.finAll(request);
         map.put("productInfoPage", productInfoPage);
         map.put("currentPage", page);
         map.put("size", size);
         return new ModelAndView("product/list", map);
     }

    @RequestMapping("/on_sale")
     public ModelAndView onSale(@RequestParam("productId") String productId,
                                Map<String, Object> map){
         try {
             ProductInfo productInfo = productService.onSale(productId);
         } catch (Exception e) {
             map.put("msg", e.getMessage());
             map.put("url", "/sell/seller/product/list");
             return new ModelAndView("common/error", map);
         }

         map.put("url", "/sell/seller/product/list");
         return new ModelAndView("common/success", map);
     }

    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String, Object> map){
        try {
            ProductInfo productInfo = productService.offSale(productId);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                      Map<String, Object> map){
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);

        return new ModelAndView("product/index", map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form, BindingResult bindingResult,
                             Map<String, Object> map){
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        //ProductInfo productInfo = JSON.parseObject(JSON.toJSONString(form), ProductInfo.class);
        ProductInfo productInfo = new ProductInfo();
        try {
            if (!StringUtils.isEmpty(form.getProductId())) {
                productInfo = productService.findOne(form.getProductId());
            }else {
                form.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form, productInfo);
            productService.save(productInfo);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}