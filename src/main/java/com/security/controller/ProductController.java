package com.security.controller;

import com.security.object.Product;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/product")
    public List<Product> springjava(){
        Product prdObj = new Product();
        List<Product> listofproduct = new ArrayList<>();
        prdObj.setId(1);
        prdObj.setName("Iqoo phone");
        prdObj.setPrice("20000");
        listofproduct.add(prdObj);
        prdObj.setId(2);
        prdObj.setName("One+ phone");
        prdObj.setPrice("40000");
        listofproduct.add(prdObj);
        return listofproduct;
    }

    @GetMapping("/prod/home")
    public String producthome(){
        return "this is product home new api";
    }
}
