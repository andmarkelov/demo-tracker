package com.wmrk.demotracker.repo;


import com.wmrk.demotracker.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    public User findByNameIgnoreCase(String username);
    public boolean existsByNameIgnoreCase(String name);
}
