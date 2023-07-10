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

import com.develop.backend.Model.Membership;
import com.develop.backend.Service.MembershipService;

@RestController
@RequestMapping(value = "/memb")
public class MembershipController {
	
	@Autowired 
	private MembershipService memberService;
	
	/////////////////////////////// Controller usando metodos de JpaRepository ////////////////////////////////////////////////////
	
	@GetMapping(value = "/allmembers")
	public List<Membership> findAllMember() {
		return memberService.findAll();	
	}
	
	@GetMapping(value = "/member/{id}")
	public Membership findByMember(@PathVariable Long id) {
		return memberService.findById(id);	
	}
	
	@PostMapping(value = "/newmember")
	public String newMember(@RequestBody Membership member) {
		memberService.save(member);
		return "Membership agregado correctamente";
	}
	
	@PutMapping(value = "/editmember/{id}")
	public String editMember(@RequestBody Membership member, @PathVariable Long id) {
		Membership existMember = this.memberService.findById(id);
		existMember.setName(member.getName());
		existMember.setPrio(member.getPrio());
		existMember.setDuration(member.getDuration());
		this.memberService.save(member);
		
		return "El Membership ha sido modificado con exito";
	}
	
	
	@DeleteMapping(value = "/delmember/{id}")
	public String detMember(@PathVariable Long id, Membership member) {
		memberService.delete(id);
		return "El Membership ha sido eliminado correctamente!";
	}

}
