package com.schools.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schools.management.Model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	 User findByEmail(String loginId);
	 
}
