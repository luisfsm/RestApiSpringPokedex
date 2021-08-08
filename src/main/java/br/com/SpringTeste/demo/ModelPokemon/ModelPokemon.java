package br.com.SpringTeste.demo.ModelPokemon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name = "TB_POKEMON")
public class ModelPokemon {
	
	@Id
	private Long IdPokedex;
	
	private String pokemon;
	private String tipo;
	private String urlImage;
	
	
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public Long getIdPokedex() {
		return IdPokedex;
	}
	public void setIdPokedex(Long idPokedex) {
		IdPokedex = idPokedex;
	}
	
	

	public String getPokemon() {
		return pokemon;
	}
	public void setPokemon(String pokemon) {
		this.pokemon = pokemon;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
