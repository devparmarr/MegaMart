package com.example.MegaMart.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="seller")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "email_Id", nullable = false, unique = true)
    String emailId;

    @Column(name = "mob_no", nullable = false, unique = true)
    String mobNo;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    List<Product> products =new ArrayList<>();

}
