package com.develop.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.backend.Model.Products;
import com.develop.backend.Repository.ProductsRepository;

@Service
public class ProductsServices {
	
	@Autowired
	ProductsRepository productsRepository;
	
	
	public List<Products> findAll() {
        return productsRepository.findAll();
    }
    
    public Products findId(Long id) {
    	return productsRepository.findById(id).orElse(null);
    }
    
    public Products save(Products products) {
    	return productsRepository.save(products);
    }
    
    
    public void delete(Long id) {
    	productsRepository.deleteById(id);
    }

}
