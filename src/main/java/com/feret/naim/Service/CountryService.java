package com.feret.naim.Service;

import com.feret.naim.beans.Country;

import java.util.List;

public interface CountryService {
    public List<Country> getAllCountry();

    public Country addCountry(Country country);

    public int removeCountry(long id);

    public Country findCountryById(long id);

    public Country updateCountry(Country country, long id);

    public Country findCountryByName(String countryName);
}
