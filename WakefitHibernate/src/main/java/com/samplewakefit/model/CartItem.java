package com.samplewakefit.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "furniture_id")
    private Furniture furniture;

    private int quantity;

    // Constructors, getters, setters
    public CartItem() {}

    public CartItem(Furniture furniture, int quantity) {
        this.furniture = furniture;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", furniture=" + furniture +
                ", quantity=" + quantity +
                '}';
    }
}
