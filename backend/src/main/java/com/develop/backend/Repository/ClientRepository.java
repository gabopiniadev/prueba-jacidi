package com.develop.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.develop.backend.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	//////////////////////// Creacion de Clientes con @Query    ///////////////////////////////////////////////
    
	@Query(value = "insert into clients (dni, name, lastname, email, lastdelivery, nextrenewal) values (?, ?, ?, ?, CURDATE(), CURDATE())", nativeQuery = true)
	void insertClient(String dni, String name, String lastname, String email);
	
	////////////////////// FIN de Creacion de Clientes con @Query /////////////////////////////////////////////
	
	///////////////////// Busqueda de Clientes Segun su ID ////////////////////////////////////////////////////
	@Query(value = "SELECT id, dni, name, lastname, email, lastdelivery, nextrenewal, membership FROM clients", nativeQuery = true)
	List<Client> findAllClients();
	
	@Query(value = "SELECT id, dni, name, lastname, email, lastdelivery, nextrenewal, membership FROM clients WHERE id = ?", nativeQuery = true)
	Client findClientById(Long id);
	
	//////////////////////FIN de Creacion de Clientes con @Query /////////////////////////////////////////////
	
	///////////////////// Actualizacion de Clientes Segun su ID //////////////////////////////////////////////////
	
	@Query(value = "UPDATE clients SET dni = ? WHERE id = ?", nativeQuery = true)
	void updatedDniClient(String dni, Long id);
	
	@Query(value = "UPDATE clients SET name = ? WHERE id = ?", nativeQuery = true)
	void updateNameClient(String name, Long id);
	
	@Query(value = "UPDATE clients SET lastname = ? WHERE id = ?", nativeQuery = true)
	void updateLastNameClient(String lastname, Long id);
	
	@Query(value = "UPDATE clients SET email = ? WHERE id = ?", nativeQuery = true)
	void updateEmailClient(String email, Long id);
	
	//////////////////////FIN de Actualizacion de Clientes con @Query /////////////////////////////////////////////
	
	//////////////////////// Eliminacion de Clientes segun su ID unico ///////////////////////////////////////////
	
	@Query(value = "DELETE FROM clients WHERE id = ?", nativeQuery = true)
	void deleteClient(Long id);
	
	//////////////////////FIN de Eliminacion de Clientes con @Query /////////////////////////////////////////////
}
