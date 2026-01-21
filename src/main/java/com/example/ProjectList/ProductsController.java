package com.example.ProjectList;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //  GET lista prodotti
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // POST aggiungi prodotto
    @PostMapping("/add")
    public Product addProduct(@RequestBody ProductDTO request) {

        Product newProduct = new Product(
                request.getName() != null ? request.getName() : "Unknown",
                request.getQuantity() != null ? request.getQuantity() : 0,
                request.getDate() != null ? request.getDate() : LocalDate.now(),
                request.getNote() != null ? request.getNote() : "Unknown"
        );

        return productRepository.save(newProduct);
    }

    //PUT modidica prodotti
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody ProductDTO request)
    {
        return productRepository.findById(id).map(existing -> {
            existing.setName(request.getName() != null ? request.getName() : existing.getName());
            existing.setQuantity(request.getQuantity() != null ? request.getQuantity() : existing.getQuantity());
            existing.setDate(request.getDate() != null ? request.getDate() : existing.getDate());
            existing.setNote(request.getNote() != null ? request.getNote(): existing.getNote());
            return productRepository.save(existing);
        }).orElse(null);
    }

    //DELETE elimina prodotti

    @DeleteMapping("/delete/{id}")
    public String deleteProd(@PathVariable long id)
    {
        productRepository.deleteById(id);
        return "suca!";
    }
}
