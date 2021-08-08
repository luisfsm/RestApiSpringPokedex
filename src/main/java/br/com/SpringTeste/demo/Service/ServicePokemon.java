package br.com.SpringTeste.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.com.SpringTeste.demo.ModelPokemon.ModelPokemon;
import br.com.SpringTeste.demo.RepositoryPokemon.RepositoryPokemon;

@Service
public class ServicePokemon {

	@Autowired
	RepositoryPokemon repositoryPokemon;
	
	public ModelPokemon InsertPokemon(ModelPokemon modelPokemon) {
		
		return repositoryPokemon.save(modelPokemon);
	}
	
	public List<ModelPokemon> listarPokemon(){
		return repositoryPokemon.findAll();
	}
	
	public Optional<ModelPokemon> listarPokemonId(Long id){
		return repositoryPokemon.findById(id);
		
	}
	
}
