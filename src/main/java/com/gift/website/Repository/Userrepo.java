package com.gift.website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gift.website.Modal.Users;

@Repository
public interface Userrepo extends JpaRepository<Users,Integer>{
    
}
