package demo.ies.lab3.quoteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mankings.ies.lab3.quoteapp.entity.*;
import mankings.ies.lab3.quoteapp.service.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Serv service;
    
    // movies
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return service.getAllMovies();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable(name = "id") int id) {
        return service.getMovieById(id);
    }

    @PostMapping("/addmovie")
    public Movie addMovie(@RequestBody Movie m) {
        return service.saveMovie(m);
    }

    @PostMapping("/addmovielist")
    public List<Movie> addMovieList(@RequestBody List<Movie> ml) {
        return service.saveAllMovies(ml);
    }

    @PutMapping("/updatemovie/{id}")
    public Movie updateMovie(@PathVariable(name = "id") int id, @RequestBody Movie m) {
        return service.updateMovie(id, m);
    }

    @DeleteMapping("/deletemovie/{id}")
    public Boolean deleteMovie(@PathVariable(name = "id") int id) {
        return service.deleteMovie(id);
    }

    // quotes
    @GetMapping("/quotes")
    public List<Quote> getQuotes() {
        return service.getAllQuotes();
    }

    @GetMapping("/quote/{id}")
    public Quote getQuoteById(@PathVariable(name = "id") int id) {
        return service.getQuoteById(id);
    }

    @PostMapping("/addquote")
    public Quote addQuote(@RequestBody NewQuote q) {
        return service.saveQuote(q);
    }

    @PostMapping("/addquotelist")
    public List<Quote> addQuoteList(@RequestBody List<NewQuote> ql) {
        return service.saveAllQuotes(ql);
    }

    @PutMapping("/updatequote/{id}")
    public Quote updateQuote(@PathVariable(name = "id") int id, @RequestBody NewQuote nq) {
        return service.updateQuote(id, nq);
    }

    @DeleteMapping("/deletequote/{id}")
    public Boolean deleteQuote(@PathVariable(name = "id") int id) {
        return service.deleteQuote(id);
    }
}
