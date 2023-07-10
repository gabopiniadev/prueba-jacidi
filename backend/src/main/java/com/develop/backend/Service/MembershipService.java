package com.develop.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.backend.Model.Membership;
import com.develop.backend.Repository.MembershipRepository;

@Service
public class MembershipService {

	@Autowired
	MembershipRepository memberRepository;
	
	public List<Membership> findAll() {
        return memberRepository.findAll();
    }
    
    public Membership findById(Long id) {
    	return memberRepository.findById(id).orElse(null);
    }
    
    public Membership save(Membership member) {
    	return memberRepository.save(member);
    }
    
    
    public void delete(Long id) {
    	memberRepository.deleteById(id);
    }
	
}
