package com.example.SalesManagerProducts.persistence;

import com.example.SalesManagerProducts.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Integer> {

    @Query("From Sale s WHERE s.dateSold BETWEEN ?1 and ?2")
    List<Sale> getSalesByTimePeriod(Date startDate, Date endDate);
}
