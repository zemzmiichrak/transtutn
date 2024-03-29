package com.transtu.tn.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.transtu.tn.Entity.User;

@Repository

public interface UserRepository extends JpaRepository<User,Long>{
	 
    @Query("SELECT r FROM Role r WHERE r.label = ?1")
	User findByEmail(String email);

	
 
}
