package edu.firstwebapp.spring5webapp.repositories;

import edu.firstwebapp.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
