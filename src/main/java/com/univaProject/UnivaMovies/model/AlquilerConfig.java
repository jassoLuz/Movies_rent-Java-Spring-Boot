package com.univaProject.UnivaMovies.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlquilerConfig {
	@Bean
	CommandLineRunner commandLineRunnerA(IAlquilerRepository ialquilerRepository)
	{
		
	return args ->{
		
		List<Pelicula> myList = new ArrayList<Pelicula>();
		
		Pelicula shawshank = new Pelicula("The Shawshank Redemption",1994,"2hr 22mins","Two imprisoned men bond over a number of years, finding solace and eventual redemption through..."
		  ,"Frank Darabont","B","Drama",3); 
		
		Pelicula inception = new Pelicula("Inception",2010,"2hrs 28mins","Dom Cobb es un ladrón con una extraña habilidad para entrar a los sueños de la gente y robarles los secretos de sus subconscientes"
		  ,"Christopher Nolan","C","Science Fiction",4); 
		
		Pelicula fightclub = new Pelicula("Fight Club",1999,"2hrs 19mins","Un empleado de oficina insomne, harto de su vida, se cruza con un vendedor peculiar...","David Fincher","C","Suspenso/Drama",2);
		 				
		
		myList.add(inception);
		myList.add(shawshank);
		myList.add(fightclub);

		
		 Socio mariana= new Socio("Mariana Navidad","Arcos #34, Los Arcos","4446784563"); 
		 Socio sebastian= new Socio("Sebastian Mendoza","Rios #38, Mares","4336784563");
		 Socio roberto= new Socio("Roberto Obregon","Estrella #89, Universo","4556784563");
		
		Alquiler shawshankAlquiler = new Alquiler(3,30,"efectivo",new Date(),myList,mariana);
		Alquiler inceptionAlquiler = new Alquiler(5,25,"tarjeta",new Date(),myList,sebastian);
		Alquiler inceptionAlquiler2 = new Alquiler(5,25,"efectivo",new Date(),myList,roberto);
		Alquiler fightclubAlquiler = new Alquiler(4,20,"tajeta",new Date(),myList,mariana);
		
		ialquilerRepository.saveAll(List.of(shawshankAlquiler,inceptionAlquiler,inceptionAlquiler2,fightclubAlquiler));
	};	
	}
}
