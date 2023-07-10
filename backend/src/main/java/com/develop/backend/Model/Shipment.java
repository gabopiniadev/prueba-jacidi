package com.develop.backend.Model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipment", schema="db_jacidi")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "clientid")
    private String clientid;
    
    @Column(name = "productsid")
    private Long productsid;
    
    @Column(name = "totalcost")
    private BigDecimal totalCost;
    
    @Column(name = "deliverdate")
    private Date deliverDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientid;
    }

    public void setClientId(String clientid) {
        this.clientid = clientid;
    }

    public Long getProductIds() {
        return productsid;
    }

    public void setProductIds(Long productsid) {
        this.productsid = productsid;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }
}
