package br.gov.sp.etec.gestaofesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.gov.sp.etec.gestaofesta.model.Login;
import br.gov.sp.etec.gestaofesta.repository.LoginRepository;

@Controller
public class LoginController {
	@Autowired
	LoginRepository repository;
	
	@GetMapping("/login")
	public String abrirLogin() {
		return "login";
		
		
	}
	@PostMapping("/efetuar-login")
	public String abrirLogin(Login login) {
		Login loginbanco=repository.findByEmail(login.getEmail());
		if((login.getEmail().equals(loginbanco.getEmail())) && login.getPassword().equals(loginbanco.getPassword())) {
			return "redirect:convidado/lista-convidados";
		}
		return "login";	
	}
	@GetMapping("/cadastro")
	public String abrirCadastro() {
		return "cadastro";
	}
	@PostMapping("cadastro/salvar")
	public String salvarCadastro(Login login) {
		repository.save(login);
		return "login";
	}
}
