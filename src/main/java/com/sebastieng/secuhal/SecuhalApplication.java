package com.sebastieng.secuhal;

import com.sebastieng.secuhal.entity.Groupe;
import com.sebastieng.secuhal.entity.MyUser;
import com.sebastieng.secuhal.entity.Roles;
import com.sebastieng.secuhal.repository.GroupeRepository;
import com.sebastieng.secuhal.repository.MyUserRepository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecuhalApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(SecuhalApplication.class, args);
    }


    @Autowired
    MyUserRepository myUserRepository;

    @Autowired
    GroupeRepository groupeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
    	
    	
    	Set<Roles> profil = new HashSet<Roles>();
		profil.add(Roles.ADMIN);

		Groupe admin = new Groupe(null,"ADMIN",profil);
		
		groupeRepository.save(admin);
    	
    	
        myUserRepository.save(new MyUser(
                null,
                "ut",
                passwordEncoder.encode("ut"),
                admin
        ));
 

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

