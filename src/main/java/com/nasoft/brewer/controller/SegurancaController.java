package com.nasoft.brewer.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SegurancaController {

	/*@AuthenticationPrincipal  injeta o usuario logado pelo spring secutiry*/
	@GetMapping("/login")	
	public String login(@AuthenticationPrincipal User user) {
		
		//forca redirect para home, se ha estiver locado,
		//para evitar ficar na pagina de login se já estiver logado
		if (user != null) {
			return "redirect:/cervejas";
		}
		
		return "Login";
	}
	
	@GetMapping("/403")
	public String acessoNegado() {
		return "403";
	}
	
}
