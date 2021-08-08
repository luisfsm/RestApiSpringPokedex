function insertPokemon(idPokedex,Pokemon,type,url){
    
    var pokemonInsercao= {
        "idPokedex": idPokedex,
        "pokemon": Pokemon,
        "tipo": type,
        "urlImage": url
        
    }
    
    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    var theUrl = "http://localhost:8080/inserir";
    xmlhttp.open("POST", theUrl);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.send(JSON.stringify(pokemonInsercao));

    console.log(pokemonInsercao);
}




var botao = document.querySelector(".btn")


botao.addEventListener('click',function(){
  var valorInput = document.querySelector(".inputTextPokemon");
  valorInput = valorInput.value
  
  
  valorInput = valorInput.toLowerCase();
  var httpRequisicao = new XMLHttpRequest();  

  httpRequisicao.open("GET",`http://localhost:8080/Pokedex/${valorInput}/`,false)
  httpRequisicao.send(null)


  if(httpRequisicao.status==200 || httpRequisicao.status != null){

    console.log(httpRequisicao.status)
    pokemon  = JSON.parse(httpRequisicao.responseText)
    //evolucaoPokemon = evolucaoPokemon.evolves_to.evolves_to.evolves_to.species.name;
     
    if(pokemon !=null){
        console.log("existe na base");
        var imgPokemon = document.createElement('img')
        imgPokemon.src=pokemon.urlImage
        var descPokemon= document.createElement("p") 
        var divPokemon = document.querySelector(".resultadoPesquisa")
        var dadosPokemon = document.createTextNode(`Pokedex nº ${pokemon.idPokedex} Nome:  ${pokemon.pokemon}`)
        
        if(document.querySelector("p")){
          document.querySelector("p").textContent=`Pokedex nº ${pokemon.idPokedex}    Nome:  ${pokemon.pokemon}`
             if(document.querySelector("img")){
                document.querySelector(".resultadoPesquisa img").src=imagem;
               console.log(pokemon);
            }
        }else{
            descPokemon.appendChild(dadosPokemon)
            divPokemon.appendChild(imgPokemon)
            divPokemon.appendChild(descPokemon)
        }
    }

    if(pokemon ==null){
        httpRequisicao.open("GET",`https://pokeapi.co/api/v2/pokemon/${valorInput}`,false)
        httpRequisicao.send(null)
      
        if(httpRequisicao.status==200){
            var retornoPokemon = JSON.parse(httpRequisicao.responseText)
            var idPokedex = retornoPokemon.id;
            var nomePokemon = retornoPokemon.name;
            var tipoPokemon = retornoPokemon.types[0].type.name;

            if(typeof retornoPokemon.types[1]  === "undefined"){
                console.log("nao possui segundo type")
                
            }else{
                tipoPokemon +=" / "+retornoPokemon.types[1].type.name
            }
            
            var imagemPokemon = retornoPokemon.sprites.front_default;

            console.log(tipoPokemon);

        insertPokemon(idPokedex,nomePokemon,tipoPokemon, imagemPokemon)
            

        var imgPokemon = document.createElement('img')
        imgPokemon.src=imagemPokemon
        var descPokemon= document.createElement("p") 
        var divPokemon = document.querySelector(".resultadoPesquisa")
        var dadosPokemon = document.createTextNode(`Pokedex nº ${idPokedex} Nome:  ${nomePokemon}`)
        
        if(document.querySelector("p")){
          document.querySelector("p").textContent=`Pokedex nº ${idPokedex}    Nome:  ${nomePokemon}`
             if(document.querySelector("img")){
                document.querySelector(".resultadoPesquisa img").src=imagemPokemon
            }
        }else{
            descPokemon.appendChild(dadosPokemon)
            divPokemon.appendChild(imgPokemon)
            divPokemon.appendChild(descPokemon)
        }
      }else{
        alert("Pokemon invalido")
        }
      }
   }
   
});