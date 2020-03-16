package com.feret.naim.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vinName;
    private String description;
    private Long price;
    private Long points;
    @ManyToOne
    private Winary winary;
    @ManyToOne
    private Variety variety;
    @ManyToOne
    private Vin vin;
}
