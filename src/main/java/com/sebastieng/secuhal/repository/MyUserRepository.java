package com.sebastieng.secuhal.repository;

import com.sebastieng.secuhal.entity.MyUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

	Optional<MyUser> findByUt(String ut);

}
