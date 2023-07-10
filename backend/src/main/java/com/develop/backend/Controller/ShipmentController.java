package com.develop.backend.Controller;

import java.util.Date;
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

import com.develop.backend.Model.Client;
import com.develop.backend.Model.Membership;
import com.develop.backend.Model.Products;
import com.develop.backend.Model.Shipment;
import com.develop.backend.Service.ClientService;
import com.develop.backend.Service.MembershipService;
import com.develop.backend.Service.ProductsServices;
import com.develop.backend.Service.ShipmentService;

@RestController
@RequestMapping(value = "/ship")
public class ShipmentController {
	
	@Autowired
	ProductsServices productService;
	
	@Autowired
	ClientService clientservice;
	
	@Autowired
	ShipmentService shipm;
	
	@Autowired
	MembershipService memberService;
	
	@GetMapping(value = "/allShip")
	public List<Shipment> getShipAll() {
		return shipm.findAll();
	}
	
	@GetMapping(value = "/shipid/{id}")
	public Shipment getShpId(Long id) {
		return shipm.findId(id);
	}
	
	@PostMapping(value = "/newship")
	public void newClient(@RequestBody Shipment member) throws Exception {
		Long value = Long.valueOf(member.getClientId());
		Client client = clientservice.findById(value);
		Membership memb = memberService.findById(value);
			if(memb == null) {
				throw new Exception("El memberShip no esta registrado");
			}
		Products product = new Products();
		
		Boolean date = client.getNextrenewal().before(new Date());
		
		if(client.getNextrenewal().before(new Date())) {
			throw new Exception("El memberShip del cliente esta vencido!");
			
		}
		
		if(product.getMinPrio() <= memb.getPrio()) {
			throw new Exception("El minPrio del producto debe ser mayor que la membresía del cliente.prio");
	           
		}
		
		/*BigDecimal totalCost = BigDecimal.ZERO;
			
		Long valuers = member.getProductIds();
			
		totalCost = totalCost.add(valuers.getCost());
			
		
		member.setTotalCost(totalCost);
		shipm.save(member);*/
		 

	     //member.setDeliverDate(new Date(System.currentTimeMillis() + (member.getProductIds().size() * (memb.getPrio() / 100))));

	     shipm.save(member);
	    		
	}
	
	@PutMapping(value = "/editproduct/{id}")
	public String editShip(@RequestBody Shipment shipment, @PathVariable Long id) {
		Shipment existShip = this.shipm.findId(id);
		existShip.setClientId(shipment.getClientId());
		existShip.setTotalCost(shipment.getTotalCost());
		
		this.shipm.save(shipment);
		
		return "El Shipment ha sido modificado con exito";
	}
	
	@DeleteMapping(value = "/removeProduct/{id}/{idp}")
	public String removeShip(@PathVariable Long id, @PathVariable Long idp) {
		Products product = productService.findId(id);
		Shipment shipms = shipm.findId(idp);
		
		Long idPrd = product.getId();
		Long idShip = shipms.getId();
		
		
		shipm.deleteById(idPrd);;
		
		return "El Shipment se elimino correctamente";
	}
	
	@DeleteMapping(value = "/delproduct/{id}")
	public String delProduct(@PathVariable Long id, Shipment shipment) {
		productService.delete(id);
		return "El Shipment ha sido eliminado correctamente!";
	}

}
