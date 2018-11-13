package com.spm.project.repository;


import com.spm.project.domain.ProductEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface GrowthManagementRepository extends CrudRepository<ProductEvent, Long> {
    //@Query(value = "SELECT * FROM product where BETWEEN LaunchDate = ?1 AND LaunchDate = ?2", nativeQuery = true)
    List<ProductEvent> getAllLaunchDateEqualsStartDateBeforeAndLaunchDateEqualsEndDateAfter(Date StartDate, Date EndDate, Date LaunchDate);
    
}
