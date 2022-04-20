package edu.firstwebapp.spring5webapp.repositories;

import edu.firstwebapp.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
