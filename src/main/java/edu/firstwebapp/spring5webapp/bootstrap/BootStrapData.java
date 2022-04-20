package edu.firstwebapp.spring5webapp.bootstrap;

import edu.firstwebapp.spring5webapp.model.Author;
import edu.firstwebapp.spring5webapp.model.Book;
import edu.firstwebapp.spring5webapp.model.Publisher;
import edu.firstwebapp.spring5webapp.repositories.AuthorRepository;
import edu.firstwebapp.spring5webapp.repositories.BookRepository;
import edu.firstwebapp.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("Publis ","London");
        publisherRepository.save(publisher);

        Author eric =  new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","A123456");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublishers(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE","561565");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublishers(publisher);
        publisher.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);



        System.out.println("Bootstrap Started");
        System.out.println("Number of Books"+bookRepository.count());
        System.out.println("Publishers Number of Books"+publisher.getBooks().size());



    }
}
