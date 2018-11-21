package com.spm.project.service;

import com.spm.project.domain.ClientEvent;
import com.spm.project.domain.ProductEvent;
import com.spm.project.domain.SalesEvent;
import com.spm.project.repository.ProductUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
public class ProductUsageService {

    @Autowired
    private ProductUsageRepository productUsageRepository;


    public int product_Usage(int id, String month, int year) {
        List<SalesEvent> products_list = productUsageRepository.findBySalesIDAndMonthAndFinancialYear(id,month,year);
        return products_list.size();
    }


    public double productTotalProfit (int id, String month, int year) {
        List<SalesEvent> products_list = productUsageRepository.findBySalesIDAndMonthAndFinancialYear(id,month,year);
        SalesEvent salesEvent = products_list.get(0);
        int units_sold = salesEvent.getUnitsSold();
        double selling_Price = salesEvent.getSellingPrice();
        return units_sold*selling_Price;
    }

    public double sellingPricetotal (String month, int year){
        List<SalesEvent> products_list = productUsageRepository.findByMonthAndFinancialYear(month,year);
        double total = 0;
        for (SalesEvent s: products_list) {
            total = total + s.getUnitsSold()*s.getUnitsSold();
        }
        return total;
    }
    public List<Integer>  allPIDBasedOnMonthYear(String month, int year){
        List<SalesEvent> product_list = productUsageRepository.findByMonthAndFinancialYear(month,year);
        List<Integer> data = new ArrayList<>();
        for (SalesEvent s:product_list
             ) {
                Integer e = s.getProduct().getProductID();
                data.add(e);
        }
        return data;
    }

    public int leastSoldProduct(int clientID){
     List<SalesEvent> salesEvents = productUsageRepository.findByClient_ClientID(clientID);
     Map<Integer,Integer> productCount = new HashMap<Integer,Integer>();
     for (SalesEvent s:salesEvents) {
         if(productCount.containsKey(s.getProduct().getProductID())){
             int units = s.getUnitsSold();
             int total = productCount.get(s.getProduct().getProductID())+units;
             productCount.replace(s.getProduct().getProductID(),total);
         }
         else {
             productCount.put(s.getProduct().getProductID(),s.getUnitsSold());
         }
        }

        int leastSoldProductID = Collections.min(productCount.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
     return leastSoldProductID;

    }


}