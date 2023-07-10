package com.develop.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.backend.Model.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long>{

}
