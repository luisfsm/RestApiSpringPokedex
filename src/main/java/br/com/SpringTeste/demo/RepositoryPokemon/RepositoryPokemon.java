package br.com.SpringTeste.demo.RepositoryPokemon;
import br.com.SpringTeste.demo.ModelPokemon.ModelPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPokemon extends JpaRepository<ModelPokemon,Long>  {

	
}
