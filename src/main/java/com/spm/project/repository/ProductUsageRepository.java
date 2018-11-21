package com.spm.project.repository;


import com.spm.project.domain.ClientEvent;
import com.spm.project.domain.ProductEvent;
import com.spm.project.domain.SalesEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUsageRepository extends CrudRepository<SalesEvent, Long> {
    List<SalesEvent> findBySalesIDAndMonthAndFinancialYear(int salesID, String month, int financialYear);
    List<SalesEvent> findByMonthAndFinancialYear(String month, int financialYear);
    List<SalesEvent> findByClient_ClientID(int clientID);
}
