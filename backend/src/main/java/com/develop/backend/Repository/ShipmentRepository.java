package com.develop.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.develop.backend.Model.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long>{

    @Query(value = "DELETE FROM shipment WHERE productsid = ?", nativeQuery = true)
    void deleteShipment(Long id);

}
