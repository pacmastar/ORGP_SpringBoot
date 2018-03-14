package com.example.demo.repository;

import com.example.demo.models.AppUsers;
import org.springframework.data.repository.CrudRepository;

public interface AppUsersRepo  extends CrudRepository<AppUsers,Integer>{
}
