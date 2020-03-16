package com.feret.naim.ServiceImpl;

import com.feret.naim.Dao.CountryDao;
import com.feret.naim.Service.CountryService;
import com.feret.naim.beans.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;

    @Override
    public List<Country> getAllCountry() {

        return countryDao.findAll();
    }

    @Override
    public Country addCountry(Country country) {
        Country country1 = countryDao.findCountryByCountryName(country.getCountryName());
        if (country1 != null) {
            return null;
        } else {
            countryDao.save(country);
            return country;
        }
    }

    @Override
    public int removeCountry(long id) {
        Country country = countryDao.findById(id).get();
        if (country == null) {
            return -1;
        }
        countryDao.deleteById(id);
        return 1;
    }

    @Override
    public Country findCountryById(long id) {
        Country country = countryDao.findById(id).get();
        if (country == null) {
            throw new RuntimeException("COUNTRY Doesn't exist");
        }
        return country;
    }

    @Override
    public Country updateCountry(Country country, long id) {
        Country country1 = findCountryById(id);
        if (country1 == null) {
            throw new RuntimeException("ERROR!! please try again");
        } else {
            country.setId(id);
            countryDao.save(country);
            return country;
        }
    }

    @Override
    public Country findCountryByName(String country_name) {
        Country country = countryDao.findCountryByCountryName(country_name);
        if (country == null) {
            throw new RuntimeException("COUNTRY Doesn't exist");
        }
        return country;
    }
}
