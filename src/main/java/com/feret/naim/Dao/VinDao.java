package com.feret.naim.Dao;

import com.feret.naim.beans.Province;
import com.feret.naim.beans.Vin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VinDao extends JpaRepository<Vin, Long> {
}
