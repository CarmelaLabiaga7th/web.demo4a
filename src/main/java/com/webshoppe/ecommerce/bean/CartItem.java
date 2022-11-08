package com.webshoppe.ecommerce.bean;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;

    public BigDecimal getTotalPrice() {
        return getPrice().multiply(new BigDecimal(quantity));
    }
    
}
