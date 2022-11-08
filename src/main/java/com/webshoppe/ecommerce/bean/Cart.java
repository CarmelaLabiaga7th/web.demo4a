package com.webshoppe.ecommerce.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<String, CartItem> items;

    public Cart() {
        items = new HashMap<>();
    }

    public int countItems() {
        return items.size();
    }

    public void add(CartItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Cart item cannot be null");
        }

        String itemId = item.getId().trim();
        if (items.containsKey(item.getId().trim())) {
            items.get(itemId).setQuantity(items.get(itemId).getQuantity()+1);
        } else {
            items.put(item.getId().trim(), item);
        }

    }

    public void remove(String id) {
        CartItem item = items.get(id.trim());
        if (item == null) {
            throw new RuntimeException("Item not found");
        }
        items.remove(id.trim());
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public List<CartItem> getItemsAsList() {
        return new ArrayList<>(items.values());
    }
    
    public BigDecimal getGrandTotal() {
        BigDecimal grandTotal = new BigDecimal(0);
        for(CartItem cartItem:getItemsAsList()) {
            grandTotal = grandTotal.add(cartItem.getTotalPrice());
        }
        return grandTotal;
    }
}
