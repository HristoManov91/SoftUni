package com.springdata.springdataadvancedqueriyng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "shampoos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Shampoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String brand;
    private double price;
    @Enumerated(EnumType.ORDINAL)
    private Size size;
    @ManyToOne (optional = true)
    private Label label;
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    @JoinTable(
            joinColumns = @JoinColumn(name = "shampoo_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id" , referencedColumnName = "id")
    )
    private Set<Ingredient> ingredients = new HashSet<>();
}
