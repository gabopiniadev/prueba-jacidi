package com.develop.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.backend.Model.Products;
import com.develop.backend.Service.ProductsServices;
import com.develop.backend.Service.ShipmentService;

@RestController
@RequestMapping(value = "/product")
public class ProductsController {
	
	@Autowired
	ProductsServices productService;
	
	@Autowired
	ShipmentService shipm;
	
	@GetMapping(value = "/allProducts")
	public List<Products> getProductsAll() {
		return productService.findAll();
	}
	
	@GetMapping(value = "/product")
	public Products getProduct(Long id) {
		return productService.findId(id);
	}
	
	@PostMapping(value = "/newproduct")
	public String newProduct(@RequestBody Products product) {
		productService.save(product);
		return "Producto agregado Correctamente";
	}
	
	@PutMapping(value = "/editproduct/{id}")
	public String editProduct(@RequestBody Products product, @PathVariable Long id) {
		Products existProduct = this.productService.findId(id);
		existProduct.setCost(product.getCost());
		existProduct.setMinPrio(product.getMinPrio());
		existProduct.setName(product.getName());
		this.productService.save(product);
		
		return "El Producto ha sido modificado con exito";
	}
	
	@DeleteMapping(value = "/delproduct/{id}")
	public String delProduct(@PathVariable Long id, Products product) {
		productService.delete(id);
		return "El Cliente ha sido eliminado correctamente!";
	}
	
}
