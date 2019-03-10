package com.sebastieng.secuhal.repository;

import com.sebastieng.secuhal.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
