package com.example.MegaMart.Model;

import com.example.MegaMart.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="card")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "card_no", nullable = false, unique = true)
    String cardNo;

    @Column(name = "cvv")
    int cvv;

    @Column(name = "CardType")
    @Enumerated(EnumType.STRING)
    CardType cardType;

    @Column(name = "vaild_till")
    Date vaildTill;

    @ManyToOne
    @JoinColumn
    Customer customer;

}
