package com.feret.naim.Dao;

import com.feret.naim.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CountryDao extends JpaRepository<Country, Long> {
    public Country findCountryByCountryName(String countryName);
}
