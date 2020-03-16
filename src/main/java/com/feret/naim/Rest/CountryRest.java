package com.feret.naim.Rest;

import com.feret.naim.Service.CountryService;
import com.feret.naim.beans.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feret/country/")
public class CountryRest {
    @GetMapping("AllCountry")
    public List<Country> getAllCountry() {
        return countryService.getAllCountry();
    }

    @PostMapping("newCountry")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @GetMapping("removeCountry")
    public int removeCountry(@PathVariable long id) {
        return countryService.removeCountry(id);
    }

    @GetMapping("getCountryById")
    public Country findCountryById(@PathVariable long id) {
        return countryService.findCountryById(id);
    }

    @PutMapping("updateCountry/id/{id}")
    public Country updateCountry(@RequestBody Country country, @PathVariable long id) {
        return countryService.updateCountry(country, id);
    }

    @GetMapping("getCOuntryByName")
    public Country findCountryByName(@PathVariable String countryName) {
        return countryService.findCountryByName(countryName);
    }

    @Autowired
    private CountryService countryService;
}
