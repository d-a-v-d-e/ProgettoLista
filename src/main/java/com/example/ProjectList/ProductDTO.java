package com.example.ProjectList;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class ProductDTO {
    private String name;
    private Integer quantity;
    private LocalDate date;
    private String note;

    public ProductDTO() {}

    public ProductDTO(String name, Integer quantity, LocalDate date, String note) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
        this.note = note;
    }

    public String getName() { return name; }
    public Integer getQuantity() { return quantity; }
    public LocalDate getDate() { return date; }
    public String getNote() { return note; }
}
