package com.siter.MovieSiter.Login.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siter.MovieSiter.Login.model.user;
@Repository
public interface Iuser extends  CrudRepository<user,Integer>{
 
}
