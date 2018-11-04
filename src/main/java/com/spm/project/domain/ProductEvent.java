package com.spm.project.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "product")
public class ProductEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    @Column(name = "productName") private String productName;
    @Column(name = "launchDate") private Date launchDate;
    @Column(name = "productType") private String productType;
    @Column(name = "productClass") private String productClass;
    @Column(name = "productStatus") private String productStatus;
    @Column(name = "sellingPrice") private Double sellingPrice;
    @Column(name = "manufacturingCost") private Double manufacturingCost;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getManufacturingCost() {
        return manufacturingCost;
    }

    public void setManufacturingCost(Double manufacturingCost) {
        this.manufacturingCost = manufacturingCost;
    }
}
