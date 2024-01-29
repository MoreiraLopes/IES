package com.example.demo;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerJson {

    Movie[] movies = {
        
        new Movie(1, "Inception", "You mustn't be afraid to dream a little bigger, darling.", "Eames"),
        new Movie(2, "The Godfather", "I'm gonna make him an offer he can't refuse.", "Don Vito Corleone"),
        new Movie(3, "Star Wars: The Empire Strikes Back", "I am your father.", "Darth Vader"),
        new Movie(4, "The Shawshank Redemption", "Get busy living, or get busy dying.", "Andy Dufresne"),
        new Movie(5, "The Lord of the Rings: The Fellowship of the Ring", "One does not simply walk into Mordor.", "Boromir"),
        new Movie(6, "Pulp Fiction", "Do you know what they call a Quarter Pounder with Cheese in Paris?", "Jules Winnfield"),
        new Movie(7, "The Matrix", "There is no spoon.", "Neo"),
        new Movie(8, "Forrest Gump", "Life is like a box of chocolates. You never know what you're gonna get.", "Forrest Gump"),
        new Movie(9, "The Dark Knight", "Why so serious?", "The Joker"),
        new Movie(10, "Jurassic Park", "Life finds a way.", "Dr. Ian Malcolm"),

    
    };

    @GetMapping("/api/quote")
	public Movie quote() {
		return movies[new Random().nextInt(movies.length-1)+1];
	}

    @GetMapping("/api/shows")
	public Movie[] shows() {
		return movies;
	}

    @GetMapping("/api/quotes")
	public Movie quote_movie(@RequestParam(value = "show") int id) {
		return movies[id-1];
	}   
}