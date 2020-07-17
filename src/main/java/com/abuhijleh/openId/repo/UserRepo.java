package com.abuhijleh.openId.repo;

import com.abuhijleh.openId.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Integer> {

    public Optional<User> findByUserName(String userName);

}
