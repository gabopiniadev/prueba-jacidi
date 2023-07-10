package com.develop.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.backend.Model.Shipment;
import com.develop.backend.Repository.ShipmentRepository;

@Service
public class ShipmentService {
	
	@Autowired
	ShipmentRepository shipmentRepository;
	
	public List<Shipment> findAll() {
        return shipmentRepository.findAll();
    }
    
    public Shipment findId(Long id) {
    	return shipmentRepository.findById(id).orElse(null);
    }
    
    public Shipment save(Shipment shipm) {
    	return shipmentRepository.save(shipm);
    }
    
    
    public void delete(Long id) {
    	shipmentRepository.deleteById(id);
    }

    public void deleteById(Long id) {
        shipmentRepository.deleteById(id);
    }

}
