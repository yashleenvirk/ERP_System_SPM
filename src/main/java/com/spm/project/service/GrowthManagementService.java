package com.spm.project.service;

import com.spm.project.domain.ProductEvent;
import com.spm.project.repository.GrowthManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ref.PhantomReference;
import java.sql.Date;
import java.util.List;

@Service
public class GrowthManagementService {

    @Autowired
    private GrowthManagementRepository growthManagementRepository;

    public List<ProductEvent> productsDeclined(Date StartDate, Date EndDate, String status){
        return growthManagementRepository.findByProductStatusAndLaunchDateBetween(status, StartDate,EndDate);
    }

    public double cost_total(int productID){
        ProductEvent productEvent = growthManagementRepository.findByProductID(productID);
        double manufacturingCost = productEvent.getManufacturingCost();
        double marketingCost = productEvent.getMarketingCost();
        double otherExpenses = productEvent.getOtherExpenses();
        return manufacturingCost+marketingCost+otherExpenses;
    }
}
