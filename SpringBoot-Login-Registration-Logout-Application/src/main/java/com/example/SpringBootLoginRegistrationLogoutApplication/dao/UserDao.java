package com.example.SpringBootLoginRegistrationLogoutApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SpringBootLoginRegistrationLogoutApplication.model.UserModel;

@Repository
public interface UserDao extends JpaRepository<UserModel, Long>{

	@Query("from UserModel where name=:name and password=:password")
	public List<UserModel> getByNameAndPaword(String name, String password);
	
}
