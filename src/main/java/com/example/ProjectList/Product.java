package com.example.ProjectList;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private Integer quantity;
    private LocalDate date;
    private String note;

    public Product() {}

    public Product(String name, Integer quantity, LocalDate date, String note){
        this.name = name;
        this.quantity = quantity;
        this.date = date;
        this.note = note;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
