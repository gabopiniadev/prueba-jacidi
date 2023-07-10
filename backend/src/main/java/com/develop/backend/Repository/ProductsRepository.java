package com.develop.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.backend.Model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

}
