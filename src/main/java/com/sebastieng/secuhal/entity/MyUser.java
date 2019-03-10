package com.sebastieng.secuhal.entity;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.sebastieng.secuhal.repository.MyUserRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MyUser {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ut;

    private String password;

    @ManyToOne
    private Groupe groupe;


//    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    private Set<Roles> role;

    
}
