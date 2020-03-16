package com.feret.naim.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String provinceName;
    @ManyToOne
    private Country country;
    @OneToMany
    private List<Region1> regions1;
    @OneToMany
    private List<Region2> regions2;
}
