package com.example.payment.application.core.domain;

import com.example.payment.application.core.domain.enums.SaleStatus;

import java.math.BigDecimal;

public class Sale {
    private Integer id;

    private Integer productId;

    private Integer userId;

    private BigDecimal value;

    private SaleStatus saleStatus;

    private Integer quantity;

    public Sale() {
    }

    public Sale(Integer id, Integer productId, Integer userId, BigDecimal value, SaleStatus saleStatus, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.value = value;
        this.saleStatus = saleStatus;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}