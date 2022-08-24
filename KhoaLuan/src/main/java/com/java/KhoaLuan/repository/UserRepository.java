package com.java.KhoaLuan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.java.KhoaLuan.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
