package com.samsung.basicsecurity.repositories.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {
    public List<ShoppingCartItem> items = new ArrayList<>();
    public Long TotalPrice;
    public Long TotalQty;
}
