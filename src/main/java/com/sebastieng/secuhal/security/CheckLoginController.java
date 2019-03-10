package com.sebastieng.secuhal.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ok")
@RestController
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class CheckLoginController {

	@GetMapping("/all")
	public String hello() {
		return "Hello stranger";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/secu")
	public String securedHello() {
		return "Secured Hello";
	}

	@PreAuthorize("hasRole('EDITOR')")
	@GetMapping("/editor")
	public String editordHello() {
		return "editor Hello";
	}
	
	

}