package com.develop.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.backend.Model.Client;
import com.develop.backend.Repository.ClientRepository;


@Service
public class ClientService {
    

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAllClients();
    }
    
    public Client findById(Long id) {
    	return clientRepository.findById(id).orElse(null);
    }
    
    public Client save(Client cliente) {
    	return clientRepository.save(cliente);
    }
    
    
    public void delete(Long id) {
    	clientRepository.deleteById(id);
    }
    
    
    //////////////////////// Service with Query //////////////////////////////////
    
    public Client searchByID(Long id) {
    	return clientRepository.findClientById(id);
    }
    
}
