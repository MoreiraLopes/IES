package demo.ies.lab3.quoteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mankings.ies.lab3.quoteapp.entity.*;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);
}
