package br.com.SpringTeste.demo.ControllerPokemon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.SpringTeste.demo.ModelPokemon.*;
import br.com.SpringTeste.demo.Service.ServicePokemon;

@CrossOrigin("*")
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
	
	@GetMapping("/Pokedex/{id}")
	public Optional<ModelPokemon> listarPorId(@PathVariable("id") Long Id){
		return servicePokemon.listarPokemonId(Id);

	}
}
