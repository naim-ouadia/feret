package com.feret.naim.Rest;

import com.feret.naim.Service.VinService;
import com.feret.naim.beans.Vin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feret/vin/")
public class VinRest {
    @GetMapping("AllVin")
    public List<Vin> getAllVin() {
        return vinService.getAllVin();
    }

    @PostMapping("newVin")
    public Vin addVin(@RequestBody Vin vin) {
        return vinService.addVin(vin);
    }

    @GetMapping("removeVin/id/{id}")
    public int removeVin(@PathVariable long id) {
        return vinService.removeVin(id);
    }

    @GetMapping("findById/id/{id}")
    public Vin findVinById(@PathVariable long id) {
        return vinService.findVinById(id);
    }

    @PutMapping("updateVin/id/{id}")
    public Vin updateVin(@RequestBody Vin vin, @PathVariable long id) {
        return vinService.updateVin(vin, id);
    }

    @Autowired
    private VinService vinService;

}
