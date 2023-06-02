package com.example.MegaMart.Model;

import com.example.MegaMart.Enum.Category;
import com.example.MegaMart.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    Integer price;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "product")
    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    Category category;

    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();

}
