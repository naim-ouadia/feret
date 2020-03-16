package com.feret.naim.ServiceImpl;

import com.feret.naim.Dao.VinDao;
import com.feret.naim.Service.VinService;
import com.feret.naim.beans.Vin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VinServiceImpl implements VinService {
    protected List<Long> ids = new ArrayList<>();
    private List<Vin> vins = new ArrayList<>();
    @Autowired
    private VinDao vinDao;

    @Override
    public List<Vin> getAllVin() {
        vins = vinDao.findAll();
        getAllId(vins);
        return vins;
    }

    @Override
    public Vin addVin(Vin vin) {
        Vin vin1 = findVinById(vin.getId());
        if (vin1 != null) {
            return null;
        } else {
            vinDao.save(vin);
            return vin;
        }
    }

    @Override
    public int removeVin(long id) {
        Vin vin1 = findVinById(id);
        if (vin1 == null) {
            return -1;
        } else {
            vinDao.deleteById(id);
            return 1;
        }
    }

    @Override
    public Vin findVinById(long id) {
        return vinDao.findById(binarySearch(ids, ids.get(0), ids.get(ids.size()), id)).get();
    }

    @Override
    public Vin updateVin(Vin vin, long id) {
        Vin vin1 = findVinById(id);
        if (vin1 == null) {
            return null;
        } else {
            vin.setId(id);
            vinDao.save(vin);
            return vin;
        }
    }

    public List<Long> getAllId(List<Vin> vins) {
        for (Vin vin : vins) {
            ids.add(vin.getId());
        }
        return ids;
    }

    public static long binarySearch(List<Long> ids, long first, long last, long key) {
        if (last >= first) {
            long mid = first + (last - first) / 2;
            if (ids.get((int) mid) == key) {
                return mid;
            }
            if (ids.get((int) mid) > key) {
                return binarySearch(ids, first, mid - 1, key);//recherche dans la gauche du sous-tableau
            } else {
                return binarySearch(ids, mid + 1, last, key);//recherche dans la droite du sous-tableau
            }
        }
        return -1;
    }
}
