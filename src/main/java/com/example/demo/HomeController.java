package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){

        //creating an actor
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");

        //creating a movie
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

        //Add movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        //Add the list of movies to the actor's movie list
        actor.setMovies(movies);

        //Save the actor to the database
        actorRepository.save(actor);

        //Grab all th actors from the databse and send them to
        //the template
        model.addAttribute("actors", actorRepository.findAll());
        return "index";

    }
}
