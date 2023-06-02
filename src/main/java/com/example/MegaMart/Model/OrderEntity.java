package com.example.MegaMart.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_info")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "order_id")
    String orderId;

    @Column(name = "total")
    int total;

    @CreationTimestamp
    @Column(name = "purchase_date")
    Date purchaseDate;

    @Column(name = "card_used")
    String cardUsed;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();


}
