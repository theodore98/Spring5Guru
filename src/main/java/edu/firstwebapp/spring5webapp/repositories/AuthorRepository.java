package edu.firstwebapp.spring5webapp.repositories;

import edu.firstwebapp.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long>
{
}
