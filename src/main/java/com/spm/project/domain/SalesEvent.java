package com.spm.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "sales")
public class SalesEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesID;
    @Column(name = "unitsSold") private int unitsSold;
    @Column(name = "month") private String month;
    @Column(name = "financialYear") private int financialYear;
    @Column(name = "marketingCost") private Double marketingCost;
    @Column(name = "otherExpenses") private Double otherExpenses;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clientID") private ClientEvent client;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productID") private ProductEvent product;

    public int getSalesID() {
        return salesID;
    }
    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }
    public int getUnitsSold() {
        return unitsSold;
    }
    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }

    public int getFinancialYear() {
        return financialYear;
    }
    public void setFinancialYear(int financialYear) {
        this.financialYear = financialYear;
    }

    public Double getMarketingCost() {
        return marketingCost;
    }
    public void setMarketingCost(Double marketingCost) {
        this.marketingCost = marketingCost;
    }


    public Double getOtherExpenses() {
        return otherExpenses;
    }
    public void setOtherExpenses(Double otherExpenses) {
        this.otherExpenses = otherExpenses;
    }

    public ClientEvent getClient() {
        return client;
    }

    public void setClient(ClientEvent client) {
        this.client = client;
    }

    public ProductEvent getProduct() {
        return product;
    }

    public void setProduct(ProductEvent product) {
        this.product = product;
    }
}

