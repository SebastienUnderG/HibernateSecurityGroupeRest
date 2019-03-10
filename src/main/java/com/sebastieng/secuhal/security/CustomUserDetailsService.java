package com.sebastieng.secuhal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sebastieng.secuhal.entity.MyUser;
import com.sebastieng.secuhal.repository.MyUserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String ut) throws UsernameNotFoundException {
	    if(ut == null) throw new UsernameNotFoundException(ut);

			Optional<MyUser> optionalUser = userRepository.findByUt(ut);
		     //BCryptPasswordEncoder encoder = passwordEncoder();
			
		        optionalUser
		                .orElseThrow(() -> new UsernameNotFoundException("User Name "+ut +"Not Found"));
		       
		        System.out.println(optionalUser.get().getPassword());
		        //Dans le cas où on crypt pas les data 
		        
		        //optionalUser.get().setPassword(encoder.encode(optionalUser.get().getPassword()));
		        System.out.println(optionalUser.get().getPassword());
		        
		        optionalUser.get().setPassword(optionalUser.get().getPassword());
		        
		        return optionalUser
		                .map(CustomUserDetails::new).get();
	    	

	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}


