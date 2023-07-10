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
import com.develop.backend.Service.ClientService;
import com.develop.backend.Service.MembershipService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
    private ClientService clientService;
	
	@Autowired 
	private MembershipService memberService;
	
	/////////////////////////////// Controller usando metodos de JpaRepository ////////////////////////////////////////////////////
	
	@GetMapping(value = "/allclients")
	public List<Client> findAllClient() {
		return clientService.findAll();
	}
	
	@GetMapping(value = "/client")
	public Client findById(@PathVariable Long id) {
		return clientService.findById(id);
	}
	
	@PostMapping(value = "/newclient")
	public String newClient(@RequestBody Client cliente) {
		clientService.save(cliente);
		return "Cliente agregado";
	}
	
	@PutMapping(value = "/editclient/{id}")
	public String editClient(@RequestBody Client cliente, @PathVariable Long id) {
		Client existClient = this.clientService.findById(id);
		existClient.setDni(cliente.getDni());
		existClient.setName(cliente.getName());
		existClient.setLastname(cliente.getLastname());
		existClient.setEmail(cliente.getEmail());
		this.clientService.save(cliente);
		
		return "El cliente ha sido modificado con exito";
	}
	
	@PutMapping(value = "/renewMembership/{id}/{idm}")
	public String renMemb(@PathVariable Long id, @PathVariable Long idM) {
		Client existClient = this.clientService.searchByID(id);
		Membership member = this.memberService.findById(idM);
		
		String memb = String.valueOf(member.getKey());
		
		existClient.setMembership(memb);
		existClient.setNextrenewal(new Date(System.currentTimeMillis() + member.getDuration()));
		
		return "La renovacion del MemberShip se realizo con exito!";
		
	}
	
	
	@DeleteMapping(value = "/delclient/{id}")
	public String delClient(@PathVariable Long id, Client cliente) {
		clientService.delete(id);
		return "El Cliente ha sido eliminado correctamente!";
	}
	
	
	/////////////////////////////// FIN Controller usando metodos de JpaRepository ////////////////////////////////////////////////////
	
	
	/////////////////////////////// Controller usando Querys ////////////////////////////////////////////////////
	
	
	/////////////////////////////// FINController usando Querys ////////////////////////////////////////////////////
 
}
