package com.example.Atlas.Repository;




import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Atlas.Entity.UserEntity;
public interface UserRepository  extends JpaRepository<UserEntity, Integer> {
    
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
