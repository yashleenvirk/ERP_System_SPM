package com.spm.project.repository;


import com.spm.project.domain.ProductEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface GrowthManagementRepository extends CrudRepository<ProductEvent, Integer> {
    //@Query(value = "SELECT * FROM product where productStatus = Declined AND LaunchDate BETWEEN 1999/01/01 AND 2000/01/01", nativeQuery = true)
    List<ProductEvent> findByProductStatusAndLaunchDateBetween( String status, Date StartDate, Date EndDate);
}
