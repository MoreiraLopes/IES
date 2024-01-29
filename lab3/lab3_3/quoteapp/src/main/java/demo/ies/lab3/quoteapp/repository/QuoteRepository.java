package demo.ies.lab3.quoteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mankings.ies.lab3.quoteapp.entity.*;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByMovie(Movie m);
}

