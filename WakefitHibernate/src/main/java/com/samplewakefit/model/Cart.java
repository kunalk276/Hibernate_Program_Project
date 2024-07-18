package com.samplewakefit.model;

import com.samplewakefit.dao.CartItemDAO;

import java.util.List;

public class Cart {
    private final CartItemDAO cartItemDAO;

    public Cart() {
        this.cartItemDAO = new CartItemDAO();
    }

    public void addItem(Furniture furniture, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setFurniture(furniture);
        cartItem.setQuantity(quantity);
        cartItemDAO.saveCartItem(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItemDAO.getAllCartItems();
    }

    public void clearCart() {
        cartItemDAO.clearCart();
    }

    public void addItem(CartItem cartItem) {
        cartItemDAO.saveCartItem(cartItem);
    }
}
