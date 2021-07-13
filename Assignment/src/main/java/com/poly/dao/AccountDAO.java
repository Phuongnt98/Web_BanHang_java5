package com.poly.dao;

import org.springframework.data.repository.CrudRepository;

import com.poly.entity.Account;

public interface AccountDAO extends CrudRepository<Account, String>{

}
