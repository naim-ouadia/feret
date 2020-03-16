package com.feret.naim.Dao;

import com.feret.naim.beans.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProvinceDao extends JpaRepository<Province, Long> {
}
