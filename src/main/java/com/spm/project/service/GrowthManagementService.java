package com.spm.project.service;

import com.spm.project.domain.ProductEvent;
import com.spm.project.repository.GrowthManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class GrowthManagementService {

    @Autowired
    private GrowthManagementRepository growthManagementRepository;

    public List<ProductEvent> productsDeclined(Date StartDate, Date EndDate, Date LaunchDate){
        return growthManagementRepository.getAllLaunchDateEqualsStartDateBeforeAndLaunchDateEqualsEndDateAfter(StartDate,EndDate,LaunchDate);
    }

}
