package br.com.SpringTeste.demo.ControllerPokemon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.SpringTeste.demo.ModelPokemon.*;
import br.com.SpringTeste.demo.Service.ServicePokemon;

@RestController
public class ControllerPokemon {
	
	@Autowired
	ServicePokemon servicePokemon;
	
	@GetMapping("/")
	public List<ModelPokemon> ListarAllPokemon(){
		
		return servicePokemon.listarPokemon();
	}
	
	@PostMapping("/inserir")
	public void InserirPokemon(@RequestBody ModelPokemon modelPokemon) {
		servicePokemon.InsertPokemon(modelPokemon);
	}
	
	
}
