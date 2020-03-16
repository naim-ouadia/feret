package com.feret.naim.Service;

import com.feret.naim.beans.Province;
import com.feret.naim.beans.Vin;

import java.util.List;

public interface VinService {
    public List<Vin> getAllVin();

    public Vin addVin(Vin vin);

    public int removeVin(long id);

    public Vin findVinById(long id);

    public Vin updateVin(Vin vin, long id);

}
