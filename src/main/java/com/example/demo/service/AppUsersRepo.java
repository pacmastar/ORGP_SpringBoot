package com.example.demo.service;

import com.example.demo.domain.AppUsers;
import org.springframework.data.repository.CrudRepository;

public interface AppUsersRepo  extends CrudRepository<AppUsers,Integer>{
}
