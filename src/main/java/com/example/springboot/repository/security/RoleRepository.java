package com.example.springboot.repository.security;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springboot.entity.security.Role;




public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query("SELECT r FROM Role r WHERE r.name = ?1")
	public Role findByName(String name);
	

	@Query("SELECT r FROM Role r WHERE " +
			"r.id LIKE CONCAT('%',:query,'%')")
	List<Role> searchRole(String query);


}
