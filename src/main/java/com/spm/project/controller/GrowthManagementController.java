package com.spm.project.controller;

import com.spm.project.domain.ClientEvent;
import com.spm.project.domain.ProductEvent;
import com.spm.project.service.GrowthManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/growthManagement")
public class GrowthManagementController {

    @Autowired
    private GrowthManagementService growthManagementService;

    @GetMapping("/products/startDate/{startDate}/endDate/{endDate}")
    public List<ProductEvent> productsDeclined (
             @PathVariable Date startDate,
             @PathVariable Date endDate
             ){
        List<ProductEvent> products_declined = growthManagementService.productsDeclined(startDate, endDate,"declined    ");
        return products_declined;
    }

}
