package com.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.Admin;

@Repository
public interface AdminDao extends CrudRepository<Admin, String > {

}
