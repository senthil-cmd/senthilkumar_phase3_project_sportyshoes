package com.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.User;
@Repository
public interface UserDao extends CrudRepository<User, String> {

}
